package br.com.rasmoo.integranf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    private Long id;

    @NotBlank(message = "Não pode ser nulo ou vazio")
    private String name;

    @NotBlank(message = "Não pode ser nulo ou vazio")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Não pode ser nulo ou vazio")
    @Size(min = 8, message = "Senha inválida. Deve conter mais de 8 caracteres.")
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();

    private Long userTypeId;
}
