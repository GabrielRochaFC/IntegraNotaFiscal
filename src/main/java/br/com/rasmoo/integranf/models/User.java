package br.com.rasmoo.integranf.models;

import br.com.rasmoo.integranf.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class User implements UserDetails {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_SUBSCRIBER = "ROLE_SUBSCRIBER";
    private static final String ROLE_USER = "ROLE_USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;

    @ManyToOne() // Deveria ter colocado o Fetch Type como Lazy!!!
    @JoinColumn(name = "users_type_id")
    private UserType userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Verificando se o userType é null para evitar NullPointerException
        if (userType != null && userType.getUserTypeEnum() != null) {
            if (userType.getUserTypeEnum() == UserTypeEnum.ADMIN) {
                return List.of(
                        new SimpleGrantedAuthority(ROLE_ADMIN),
                        new SimpleGrantedAuthority(ROLE_SUBSCRIBER),
                        new SimpleGrantedAuthority(ROLE_USER)
                );
            } else if (userType.getUserTypeEnum() == UserTypeEnum.SUBSCRIBER) {
                return List.of(
                        new SimpleGrantedAuthority(ROLE_SUBSCRIBER),
                        new SimpleGrantedAuthority(ROLE_USER)
                );
            }
        }
        // Caso userType seja null, ou não seja ADMIN e nem SUBSCRIBER, retorna ROLE_USER
        return List.of(new SimpleGrantedAuthority(ROLE_USER));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
