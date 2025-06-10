package com.mucida.bff_agendador.bussines.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTORequest {
    private String email;
    private String senha;
}
