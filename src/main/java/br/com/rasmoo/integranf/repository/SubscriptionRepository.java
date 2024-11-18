package br.com.rasmoo.integranf.repository;

import br.com.rasmoo.integranf.models.Subscription;
import br.com.rasmoo.integranf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByUser(User user);
}
