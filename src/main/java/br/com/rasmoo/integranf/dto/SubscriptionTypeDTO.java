package br.com.rasmoo.integranf.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionTypeDTO {

    private Long id;

    @NotBlank(message = "Não pode ser nulo ou vazio")
    private String type;

    @NotNull(message = "Não pode ser nulo")
    private BigDecimal value;

    @NotNull(message = "Não pode ser nulo")
    private Boolean enabled;
}
