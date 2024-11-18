package br.com.rasmoo.integranf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserGatewayResponseDTO {

    private Long id;

    private String apiKeyPublic;

    private String apiKeySecret;

    private String webhookUrl;

    private String webhookToken;

    private LocalDate integrationStartDate;

    private Long guaranteeDays;

    private Boolean status;

    private String userName;

    private String gatewayName;

}
