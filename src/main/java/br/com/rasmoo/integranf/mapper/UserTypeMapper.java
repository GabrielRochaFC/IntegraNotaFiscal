package br.com.rasmoo.integranf.mapper;

import br.com.rasmoo.integranf.dto.UserTypeDTO;
import br.com.rasmoo.integranf.enums.UserTypeEnum;
import br.com.rasmoo.integranf.models.UserType;

public class UserTypeMapper {

    private UserTypeMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UserType fromDtoToUserType(UserTypeDTO dto) {
        return UserType.builder()
                .id(dto.getId())
                .userTypeEnum(UserTypeEnum.valueOf(dto.getType()))
                .description(dto.getDescription())
                .build();
    }
}
