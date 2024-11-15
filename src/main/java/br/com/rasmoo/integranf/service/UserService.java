package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.UserResponseDTO;
import br.com.rasmoo.integranf.dto.UserUpdateDTO;
import br.com.rasmoo.integranf.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserResponseDTO> findAll(Pageable pageable);
    User patchUser(Long id, UserUpdateDTO data);
}
