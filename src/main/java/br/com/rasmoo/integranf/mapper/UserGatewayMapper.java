package br.com.rasmoo.integranf.mapper;

import br.com.rasmoo.integranf.dto.UserGatewayDTO;
import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserGateway;

public class UserGatewayMapper {

    private UserGatewayMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static UserGateway fromDtoToUserGateway(UserGatewayDTO userGatewayDTO, Gateway gateway, User user) {
        return UserGateway.builder()
                .id(userGatewayDTO.getId())
                .apiKeyPublic(userGatewayDTO.getApiKeyPublic())
                .apiKeySecret(userGatewayDTO.getApiKeySecret())
                .webhookUrl(userGatewayDTO.getWebhookUrl())
                .webhookToken(userGatewayDTO.getWebhookToken())
                .integrationStartDate(userGatewayDTO.getIntegrationStartDate())
                .guaranteeDays(userGatewayDTO.getGuaranteeDays())
                .status(userGatewayDTO.getStatus())
                .user(user)
                .gateway(gateway)
                .build();
    }
}
