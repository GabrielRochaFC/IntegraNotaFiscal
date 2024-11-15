package br.com.rasmoo.integranf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserUpdateDTO {

    private String email;
    private String name;
    private Long userTypeId;
}
