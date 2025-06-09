package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.EnderecoDTO;
import com.mucida.bff_agendador.infrastructure.client.EnderecoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoClient enderecoClient;

    public EnderecoDTO updateEndereco(Long id, EnderecoDTO enderecoDTO, String token) {
        return enderecoClient.updateEndereco(enderecoDTO, id, token);
    }

    public EnderecoDTO saveEndereco(EnderecoDTO enderecoDTO, String token) {
        return enderecoClient.saveEndereco(enderecoDTO, token);
    }

}
