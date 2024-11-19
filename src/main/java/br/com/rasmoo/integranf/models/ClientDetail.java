package br.com.rasmoo.integranf.models;

import br.com.rasmoo.integranf.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client_details")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "cpf_cnpj", nullable = false)
    private String cpfCnpj;

    @Column(name = "state_registration")
    private String stateRegistration;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "tipo_pessoa", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
