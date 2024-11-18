package br.com.rasmoo.integranf.mapper;

import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.dto.GatewayDTO;

public class GatewayMapper {

    private GatewayMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Gateway fromDtoToGateway(GatewayDTO dto) {
        return Gateway.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
