package br.com.rasmoo.integranf.service.impl;


import br.com.rasmoo.integranf.dto.SubscriptionRequestDTO;
import br.com.rasmoo.integranf.enums.UserTypeEnum;
import br.com.rasmoo.integranf.exception.BadRequestException;
import br.com.rasmoo.integranf.exception.BusinessException;
import br.com.rasmoo.integranf.models.Subscription;
import br.com.rasmoo.integranf.models.SubscriptionType;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.repository.SubscriptionRepository;
import br.com.rasmoo.integranf.repository.SubscriptionTypeRepository;
import br.com.rasmoo.integranf.repository.UserRepository;
import br.com.rasmoo.integranf.repository.UserTypeRepository;
import br.com.rasmoo.integranf.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionTypeRepository subscriptionTypeRepository;
    private final UserTypeRepository userTypeRepository;
    private final UserRepository userRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   SubscriptionTypeRepository subscriptionTypeRepository, UserTypeRepository userTypeRepository, UserRepository userRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionTypeRepository = subscriptionTypeRepository;
        this.userTypeRepository = userTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Subscription assignSubscription(SubscriptionRequestDTO subscriptionRequestDTO, User user) {
        SubscriptionType subscriptionType = getValidatedSubscriptionType(subscriptionRequestDTO.getSubscriptionTypeId());
        Subscription existingSubscription = subscriptionRepository.findByUser(user).orElse(null);
        if (Objects.nonNull(existingSubscription)) {
            return updateExistingSubscription(existingSubscription, subscriptionType);
        }
        updateUserTypeToSubscriber(user);
        return createNewSubscription(subscriptionRequestDTO, user, subscriptionType);
}

    private Subscription updateExistingSubscription(Subscription existingSubscription, SubscriptionType subscriptionType) {
        existingSubscription.setSubscriptionType(subscriptionType);
        return subscriptionRepository.save(existingSubscription);
    }

    private SubscriptionType getValidatedSubscriptionType(Long subscriptionTypeId) {
        // Verificando se esse tipo de inscrição existe
        SubscriptionType subscriptionType = subscriptionTypeRepository.findById(subscriptionTypeId)
                .orElseThrow(() -> new BadRequestException("SubscriptionType not found"));

        // Verifica se a inscrição está ativa ou não
        if (Boolean.FALSE.equals(subscriptionType.getEnabled())) {
            throw new BusinessException("SubscriptionType disabled");
        }
        return subscriptionType;
    }

    private void updateUserTypeToSubscriber(User user) {
        UserType userType = userTypeRepository.findByUserTypeEnum(UserTypeEnum.SUBSCRIBER)
                .orElseThrow(() -> new BadRequestException("UserType not found"));

        user.setUserType(userType);
        userRepository.save(user);
    }

    private Subscription createNewSubscription(SubscriptionRequestDTO subscriptionRequestDTO, User user, SubscriptionType subscriptionType) {
        Subscription subscription = Subscription.builder()
                .id(subscriptionRequestDTO.getSubscriptionId())
                .dateSubscribed(LocalDate.now())
                .notesPrinted(0L)
                .user(user)
                .subscriptionType(subscriptionType)
                .build();

        return subscriptionRepository.save(subscription);
    }

}
