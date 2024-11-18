package br.com.rasmoo.integranf.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GatewayDTO {

    private Long id;

    @NotBlank(message = "Não pode ser nulo ou vazio")
    private String name;

    private String description;

}
