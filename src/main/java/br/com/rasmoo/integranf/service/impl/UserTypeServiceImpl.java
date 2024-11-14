package br.com.rasmoo.integranf.service.impl;

import br.com.rasmoo.integranf.models.UserType;
import br.com.rasmoo.integranf.repository.UserTypeRepository;
import br.com.rasmoo.integranf.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }
}
