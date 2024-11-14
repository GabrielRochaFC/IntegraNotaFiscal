package br.com.rasmoo.integranf.mapper;

import br.com.rasmoo.integranf.dto.SubscriptionTypeDTO;
import br.com.rasmoo.integranf.models.SubscriptionType;

public class SubscriptionTypeMapper {

    private SubscriptionTypeMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static SubscriptionType fromDtoToSubscriptionType(SubscriptionTypeDTO dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .type(dto.getType())
                .value(dto.getValue())
                .enabled(dto.getEnabled())
                .build();
    }
}
