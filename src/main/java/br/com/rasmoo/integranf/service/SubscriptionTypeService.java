package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.SubscriptionTypeDTO;
import br.com.rasmoo.integranf.models.SubscriptionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubscriptionTypeService {

    SubscriptionType create(SubscriptionTypeDTO dto);

    Page<SubscriptionType> findAll(Pageable pageable);

    Page<SubscriptionType> findAllEnabled(Pageable pageable);
}
