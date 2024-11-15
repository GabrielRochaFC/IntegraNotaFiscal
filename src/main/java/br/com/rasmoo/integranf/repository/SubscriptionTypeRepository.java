package br.com.rasmoo.integranf.repository;

import br.com.rasmoo.integranf.models.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {
    Optional<SubscriptionType> findByType(String type);
}