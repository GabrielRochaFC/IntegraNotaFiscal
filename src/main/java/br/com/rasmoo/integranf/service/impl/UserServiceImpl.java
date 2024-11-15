package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.dto.UserResponseDTO;
import br.com.rasmoo.integranf.dto.UserUpdateDTO;
import br.com.rasmoo.integranf.mapper.UserMapper;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.repository.UserRepository;
import br.com.rasmoo.integranf.repository.UserTypeRepository;
import br.com.rasmoo.integranf.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserMapper::fromUserToDto);
    }

    @Override
    public User patchUser(Long id, UserUpdateDTO userUpdateDTO) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with id " + id + " not found")
        );

        if (userUpdateDTO.getEmail() != null) {
            user.setEmail(userUpdateDTO.getEmail());
        }
        if (userUpdateDTO.getName() != null) {
            user.setName(userUpdateDTO.getName());
        }
        if (userUpdateDTO.getUserTypeId() != null) {
            UserType userType = userTypeRepository.findById(userUpdateDTO.getUserTypeId()).orElseThrow(
                    () -> new IllegalArgumentException("User type with id " + userUpdateDTO.getUserTypeId() + " not found")
            );
            user.setUserType(userType);
        }

        return userRepository.save(user);

    }
}
