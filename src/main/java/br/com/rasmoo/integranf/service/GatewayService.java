package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.models.GatewayDTO;

import java.util.List;

public interface GatewayService {

    Gateway create(GatewayDTO gatewayDTO);

    List<Gateway> findAll();

}
