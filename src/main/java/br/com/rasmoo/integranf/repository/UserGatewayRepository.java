package br.com.rasmoo.integranf.repository;

import br.com.rasmoo.integranf.models.User;
import br.com.rasmoo.integranf.models.UserGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserGatewayRepository extends JpaRepository<UserGateway, Long> {

    @Query("SELECT ug FROM UserGateway ug JOIN FETCH ug.user JOIN FETCH ug.gateway WHERE ug.user = :user")
    Page<UserGateway> findAllByUser(@Param("user") User user, Pageable pageable);

}
