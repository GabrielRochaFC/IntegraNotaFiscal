package br.com.rasmoo.integranf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SubscriptionRequestDTO {

    private Long subscriptionId;

    @NotNull(message = "Não pode ser nulo")
    private Long subscriptionTypeId;

}
