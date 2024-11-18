package br.com.rasmoo.integranf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_subscription", nullable = false)
    private LocalDate dateSubscribed;

    @Column(name = "notes_printed", nullable = false)
    private Long notesPrinted;

    @ManyToOne()
    @JoinColumn(name = "subscriptions_type_id", nullable = false)
    private SubscriptionType subscriptionType;

    @OneToOne()
    @JoinColumn(name = "users_id")
    private User user;

}
