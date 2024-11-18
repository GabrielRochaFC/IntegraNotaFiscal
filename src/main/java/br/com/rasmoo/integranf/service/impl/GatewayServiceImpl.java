package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.mapper.GatewayMapper;
import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.models.GatewayDTO;
import br.com.rasmoo.integranf.repository.GatewayRepository;
import br.com.rasmoo.integranf.service.GatewayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatewayServiceImpl implements GatewayService {
    private final GatewayRepository gatewayRepository;

    public GatewayServiceImpl(GatewayRepository gatewayRepository) {
        this.gatewayRepository = gatewayRepository;
    }

    @Override
    public Gateway create(GatewayDTO gatewayDTO) {
        return gatewayRepository.save(GatewayMapper.fromDtoToGateway(gatewayDTO));
    }

    @Override
    public List<Gateway> findAll() {
        return gatewayRepository.findAll();
    }
}
