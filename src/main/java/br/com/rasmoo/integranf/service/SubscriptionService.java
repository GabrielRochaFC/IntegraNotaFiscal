package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.SubscriptionRequestDTO;
import br.com.rasmoo.integranf.models.Subscription;
import br.com.rasmoo.integranf.models.User;

public interface SubscriptionService {

    Subscription assignSubscription(SubscriptionRequestDTO subscriptionRequestDTO, User user);

}
