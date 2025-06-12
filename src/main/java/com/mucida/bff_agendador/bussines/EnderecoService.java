package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.request.EnderecoDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.EnderecoDTOResponse;
import com.mucida.bff_agendador.infrastructure.client.EnderecoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoClient enderecoClient;

    public EnderecoDTOResponse updateEndereco(Long id, EnderecoDTORequest enderecoDTORequest, String token) {
        return enderecoClient.updateEndereco(enderecoDTORequest, id, token);
    }

    public EnderecoDTOResponse saveEndereco(EnderecoDTORequest enderecoDTORequest, String token) {
        return enderecoClient.saveEndereco(enderecoDTORequest, token);
    }

}
