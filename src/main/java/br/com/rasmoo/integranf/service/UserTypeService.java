package br.com.rasmoo.integranf.service;

import br.com.rasmoo.integranf.dto.UserTypeDTO;
import br.com.rasmoo.integranf.models.UserType;

import java.util.List;

public interface UserTypeService {

    UserType create(UserTypeDTO dto);

    List<UserType> findAll();
}
