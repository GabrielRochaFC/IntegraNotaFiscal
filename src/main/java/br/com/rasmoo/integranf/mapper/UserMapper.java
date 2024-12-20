package br.com.rasmoo.integranf.mapper;

import br.com.rasmoo.integranf.dto.RegisterDTO;
import br.com.rasmoo.integranf.dto.UserResponseDTO;
import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserType;

public class UserMapper {

    private UserMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static User fromDtoToUser(RegisterDTO dto, UserType userType, String encryptedPassword) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(encryptedPassword)
                .userType(userType)
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public static UserResponseDTO fromUserToDto(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .userType(user.getUserType().getUserTypeEnum().name())
                .build();
    }
}
