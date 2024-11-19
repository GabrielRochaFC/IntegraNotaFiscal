package br.com.rasmoo.integranf.models;

import br.com.rasmoo.integranf.enums.TaxRegime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_details")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "trade_name", nullable = false)
    private String tradeName;

    @Column(name = "state_registration", nullable = false)
    private String stateRegistration;

    @Column(name = "tax_regime", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaxRegime taxRegime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}