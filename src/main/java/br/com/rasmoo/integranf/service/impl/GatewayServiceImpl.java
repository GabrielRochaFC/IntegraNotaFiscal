package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.dto.UserGatewayDTO;
import br.com.rasmoo.integranf.dto.UserGatewayResponseDTO;
import br.com.rasmoo.integranf.mapper.GatewayMapper;
import br.com.rasmoo.integranf.mapper.UserGatewayMapper;
import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.dto.GatewayDTO;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserGateway;
import br.com.rasmoo.integranf.repository.GatewayRepository;
import br.com.rasmoo.integranf.repository.UserGatewayRepository;
import br.com.rasmoo.integranf.service.GatewayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatewayServiceImpl implements GatewayService {
    private final GatewayRepository gatewayRepository;
    private final UserGatewayRepository userGatewayRepository;

    public GatewayServiceImpl(GatewayRepository gatewayRepository, UserGatewayRepository userGatewayRepository) {
        this.gatewayRepository = gatewayRepository;
        this.userGatewayRepository = userGatewayRepository;
    }

    @Override
    public Gateway create(GatewayDTO gatewayDTO) {
        return gatewayRepository.save(GatewayMapper.fromDtoToGateway(gatewayDTO));
    }

    @Override
    public List<Gateway> findAll() {
        return gatewayRepository.findAll();
    }

    @Override
    public UserGateway register(UserGatewayDTO dto, User user) {

        Gateway gateway = gatewayRepository.findById(dto.getGatewayId()).orElseThrow(
                () -> new IllegalArgumentException("Gateway not found")
        );

        return userGatewayRepository.save(UserGatewayMapper.fromDtoToUserGateway(dto, gateway, user));
    }

    @Override
    public Page<UserGatewayResponseDTO> findAllIntegrated(User user, Pageable pageable) {
        return userGatewayRepository.findAllByUser(user, pageable).map(
                userGateway ->
                        UserGatewayResponseDTO.builder()
                                .id(userGateway.getId())
                                .apiKeyPublic(userGateway.getApiKeyPublic())
                                .apiKeySecret(userGateway.getApiKeySecret())
                                .gatewayName(userGateway.getGateway().getName())
                                .guaranteeDays(userGateway.getGuaranteeDays())
                                .integrationStartDate(userGateway.getIntegrationStartDate())
                                .status(userGateway.getStatus())
                                .userName(userGateway.getUser().getName())
                                .webhookToken(userGateway.getWebhookToken())
                                .webhookUrl(userGateway.getWebhookUrl())
                                .build()
        );
    }
}
