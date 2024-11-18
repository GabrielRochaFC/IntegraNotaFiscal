package br.com.rasmoo.integranf.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserGatewayDTO {

    private Long id;

    @NotNull(message = "A chave pública da API não pode ser nula.")
    @Size(min = 10, max = 100, message = "A chave pública da API deve ter entre 10 e 100 caracteres.")
    private String apiKeyPublic;

    @NotNull(message = "A chave secreta da API não pode ser nula.")
    @Size(min = 10, max = 100, message = "A chave secreta da API deve ter entre 10 e 100 caracteres.")
    private String apiKeySecret;

    @NotNull(message = "A URL do webhook não pode ser nula.")
    @Size(min = 5, max = 255, message = "A URL do webhook deve ter entre 5 e 255 caracteres.")
    private String webhookUrl;

    @NotNull(message = "O token do webhook não pode ser nulo.")
    @Size(min = 5, max = 255, message = "O token do webhook deve ter entre 5 e 255 caracteres.")
    private String webhookToken;

    private LocalDate integrationStartDate = LocalDate.now();

    @NotNull(message = "Os dias de garantia não podem ser nulos.")
    @Min(value = 1, message = "Os dias de garantia devem ser pelo menos 1.")
    @Max(value = 365, message = "Os dias de garantia devem ser no máximo 365 (1 ano).")
    private Long guaranteeDays;

    @NotNull(message = "O status não pode ser nulo.")
    private Boolean status;

    private Long userId;

    @NotNull(message = "O ID do gateway não pode ser nulo.")
    private Long gatewayId;

}
