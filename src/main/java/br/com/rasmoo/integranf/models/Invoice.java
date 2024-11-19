package br.com.rasmoo.integranf.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @Column(name = "tax_value", nullable = false)
    private BigDecimal taxValue;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_details_id")
    private ClientDetail clientDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id")
    private CompanyDetail companyDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriptions_id")
    private Subscription subscription;
}
