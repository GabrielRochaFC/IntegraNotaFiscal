package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.service.UserTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    public ResponseEntity<List<UserType>> findAll() {
        return ResponseEntity.ok().body(userTypeService.findAll());
    }

}
