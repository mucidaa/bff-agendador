package com.mucida.bff_agendador.bussines.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTORequest> enderecos;
    private List<TelefoneDTORequest> telefones;

}
