package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.dto.SubscriptionTypeDTO;
import br.com.rasmoo.integranf.exception.BadRequestException;
import br.com.rasmoo.integranf.mapper.SubscriptionTypeMapper;
import br.com.rasmoo.integranf.models.SubscriptionType;
import br.com.rasmoo.integranf.repository.SubscriptionTypeRepository;
import br.com.rasmoo.integranf.service.SubscriptionTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id should be null");
        }
        subscriptionTypeRepository.findByType(dto.getType()).ifPresent(subscriptionType -> {
            throw new BadRequestException("Type already exists");
        });
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToSubscriptionType(dto));
    }

    @Override
    public Page<SubscriptionType> findAll(Pageable pageable) {
        return subscriptionTypeRepository.findAll(pageable);
    }

    @Override
    public Page<SubscriptionType> findAllEnabled(Pageable pageable) {
        return subscriptionTypeRepository.findAllByEnabledTrue(pageable);
    }


}
