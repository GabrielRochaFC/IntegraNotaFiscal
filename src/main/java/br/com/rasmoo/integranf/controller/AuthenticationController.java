package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.AuthenticationDTO;
import br.com.rasmoo.integranf.dto.RegisterDTO;
import br.com.rasmoo.integranf.dto.TokenDTO;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        TokenDTO tokenDTO = authenticationService.login(data.getEmail(), data.getPassword());
        return ResponseEntity.ok().body(tokenDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data) {
        User user = authenticationService.register(data);
        return ResponseEntity.ok().body(user);
    }
}
