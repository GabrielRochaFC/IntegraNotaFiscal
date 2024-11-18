package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.models.Gateway;
import br.com.rasmoo.integranf.models.GatewayDTO;
import br.com.rasmoo.integranf.service.GatewayService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
