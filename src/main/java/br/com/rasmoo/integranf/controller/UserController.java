package br.com.rasmoo.integranf.controller;

import br.com.rasmoo.integranf.dto.UserResponseDTO;
import br.com.rasmoo.integranf.dto.UserUpdateDTO;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "name"));
        return ResponseEntity.ok().body(userService.findAll(pageable).getContent());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @RequestBody UserUpdateDTO updateDTO) {
        return ResponseEntity.ok().body(userService.patchUser(id, updateDTO));
    }

}
