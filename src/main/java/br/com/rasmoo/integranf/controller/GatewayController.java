package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.GatewayDTO;
import br.com.rasmoo.integranf.dto.UserGatewayDTO;
import br.com.rasmoo.integranf.dto.UserGatewayResponseDTO;
import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserGateway;
import br.com.rasmoo.integranf.service.GatewayService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @PostMapping
    public ResponseEntity<Gateway> create(@Valid @RequestBody GatewayDTO gatewayDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gatewayService.create(gatewayDTO));
    }

    @GetMapping
    public ResponseEntity<List<Gateway>> getAll() {
        return ResponseEntity.ok().body(gatewayService.findAll());
    }

    @PostMapping("/integrations")
    public ResponseEntity<UserGateway> integrate(@Valid @RequestBody UserGatewayDTO dto,
                                                @AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gatewayService.register(dto, user));
    }

    @GetMapping("/integrations")
    public ResponseEntity<List<UserGatewayResponseDTO>> findAllIntegrated(@RequestParam final Integer page,
                                                                          @RequestParam final Integer size,
                                                                          @AuthenticationPrincipal User user) {
        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok().body(gatewayService.findAllIntegrated(user, pageable).getContent());

    }
}
