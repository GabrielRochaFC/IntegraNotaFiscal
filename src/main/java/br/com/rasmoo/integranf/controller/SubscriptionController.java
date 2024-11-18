package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.SubscriptionRequestDTO;
import br.com.rasmoo.integranf.models.Subscription;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {


    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/select")
    public ResponseEntity<Subscription> selectSubscription(
            @RequestBody @Valid SubscriptionRequestDTO subscriptionRequestDto,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok().body(subscriptionService.assignSubscription(subscriptionRequestDto, user));
    }

}
