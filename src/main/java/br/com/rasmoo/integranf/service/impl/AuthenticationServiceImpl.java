package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.dto.RegisterDTO;
import br.com.rasmoo.integranf.dto.TokenDTO;
import br.com.rasmoo.integranf.exception.BadRequestException;
import br.com.rasmoo.integranf.infra.security.TokenService;
import br.com.rasmoo.integranf.mapper.UserMapper;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.repository.UserRepository;
import br.com.rasmoo.integranf.repository.UserTypeRepository;
import br.com.rasmoo.integranf.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, TokenService tokenService, UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    public TokenDTO login(String email, String password) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return TokenDTO.builder().token(token).type("Bearer").build();
    }

    @Override
    public User register(RegisterDTO data) {
        if (Objects.nonNull(userRepository.findByEmail(data.getEmail()))) {
            throw new BadRequestException("e-mail already exists");
        }

        // Se o userTypeId for nulo, passo ele com o valor default como User. Apenas para fins didáticos.
        if (data.getUserTypeId() == null) {
            data.setUserTypeId(2L);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

        var userTypeOpt = userTypeRepository.findById(data.getUserTypeId());

        if (userTypeOpt.isEmpty()) {
            throw new BadRequestException("UserType not found");
        }
        UserType userType = userTypeOpt.get();

        return userRepository.save(UserMapper.fromDtoToUser(data, userType, encryptedPassword));
    }


}
