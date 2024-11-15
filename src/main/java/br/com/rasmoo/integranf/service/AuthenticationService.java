package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.RegisterDTO;
import br.com.rasmoo.integranf.dto.TokenDTO;
import br.com.rasmoo.integranf.models.User;

public interface AuthenticationService {
    TokenDTO login(String email, String password);
    User register(RegisterDTO data);
}
