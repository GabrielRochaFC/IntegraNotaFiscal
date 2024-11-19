package br.com.rasmoo.integranf.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String street;

    private Long number;

    private String neighborhood;
    private String city;
    private String state;

    @Column(nullable = false)
    private String cep;
}
