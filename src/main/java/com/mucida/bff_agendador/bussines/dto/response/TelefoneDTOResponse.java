package com.mucida.bff_agendador.bussines.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTOResponse {

    private Long id;
    private String numero;
    private String ddd;

}
