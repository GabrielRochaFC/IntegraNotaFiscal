package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.SubscriptionTypeDTO;
import br.com.rasmoo.integranf.models.SubscriptionType;
import br.com.rasmoo.integranf.service.SubscriptionTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    private final SubscriptionTypeService subscriptionTypeService;

    public SubscriptionTypeController(SubscriptionTypeService subscriptionTypeService) {
        this.subscriptionTypeService = subscriptionTypeService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionTypeDTO subscriptionTypeDTO) {
        return ResponseEntity.ok().body(subscriptionTypeService.create(subscriptionTypeDTO));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll(){
        return ResponseEntity.ok().body(subscriptionTypeService.findAll());
    }
}
