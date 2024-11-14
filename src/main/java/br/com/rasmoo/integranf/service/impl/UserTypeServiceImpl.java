package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.dto.UserTypeDTO;
import br.com.rasmoo.integranf.enums.UserTypeEnum;
import br.com.rasmoo.integranf.exception.BadRequestException;
import br.com.rasmoo.integranf.mapper.UserTypeMapper;
import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.repository.UserTypeRepository;
import br.com.rasmoo.integranf.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserType create(UserTypeDTO dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id should be null");
        }
        userTypeRepository.findByUserTypeEnum(UserTypeEnum.valueOf(dto.getType())).ifPresent(userType -> {
            throw new BadRequestException("Type already exists");
        });
        return userTypeRepository.save(UserTypeMapper.fromDtoToUserType(dto));
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }
}
