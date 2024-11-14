package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.SubscriptionTypeDTO;
import br.com.rasmoo.integranf.models.SubscriptionType;

public interface SubscriptionTypeService {

    SubscriptionType create(SubscriptionTypeDTO dto);
}
