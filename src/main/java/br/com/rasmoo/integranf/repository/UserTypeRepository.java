package br.com.rasmoo.integranf.repository;

import br.com.rasmoo.integranf.enums.UserTypeEnum;
import br.com.rasmoo.integranf.models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    Optional<UserType> findByUserTypeEnum(UserTypeEnum userTypeEnum);
}
