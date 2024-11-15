package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.SubscriptionTypeDTO;
import br.com.rasmoo.integranf.models.SubscriptionType;
import br.com.rasmoo.integranf.service.SubscriptionTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<SubscriptionType>> findAll(
            @RequestParam final Integer page,
            @RequestParam final Integer size,
            @RequestParam(required = false) Boolean enabled) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "type"));
        Page<SubscriptionType> result;

        if (enabled == null) {
            result = subscriptionTypeService.findAll(pageable);
        } else {
            result = subscriptionTypeService.findAllEnabled(pageable);
        }

        return ResponseEntity.ok().body(result);
    }
}
