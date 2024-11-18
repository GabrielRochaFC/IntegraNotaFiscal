package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.UserGatewayDTO;
import br.com.rasmoo.integranf.dto.UserGatewayResponseDTO;
import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.dto.GatewayDTO;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GatewayService {

    Gateway create(GatewayDTO gatewayDTO);

    List<Gateway> findAll();

    UserGateway register(UserGatewayDTO dto, User user);

    Page<UserGatewayResponseDTO> findAllIntegrated(User user, Pageable pageable);

}
