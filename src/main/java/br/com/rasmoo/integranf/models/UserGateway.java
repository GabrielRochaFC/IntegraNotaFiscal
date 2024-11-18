package br.com.rasmoo.integranf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users_gateways")
public class UserGateway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_key_public", nullable = false)
    private String apiKeyPublic;

    @Column(name = "api_key_secret")
    private String apiKeySecret;

    @Column(name = "webhook_url", nullable = false)
    private String webhookUrl;

    @Column(name = "webhook_token")
    private String webhookToken;

    @Column(name = "integration_start_date", nullable = false)
    private LocalDate integrationStartDate;

    @Column(name = "guarantee_days")
    private Long guaranteeDays;

    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gateway_id", nullable = false)
    private Gateway gateway;
}
