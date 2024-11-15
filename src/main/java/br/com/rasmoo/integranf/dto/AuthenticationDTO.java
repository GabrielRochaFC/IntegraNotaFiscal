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
public class AuthenticationDTO {

    @NotBlank(message = "Não pode ser vazio ou nulo")
    private String email;

    @NotBlank(message = "Não pode ser vazio ou nulo")
    private String password;
}
