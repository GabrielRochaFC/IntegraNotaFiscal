package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.UserTypeDTO;
import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.service.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @PostMapping
    public ResponseEntity<UserType> create(@Valid @RequestBody UserTypeDTO userTypeDTO) {
        return ResponseEntity.ok().body(userTypeService.create(userTypeDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserType>> findAll() {
        return ResponseEntity.ok().body(userTypeService.findAll());
    }

}
