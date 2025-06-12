package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.request.TelefoneDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TelefoneDTOResponse;
import com.mucida.bff_agendador.infrastructure.client.TelefoneClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TelefoneService {

    private final TelefoneClient telefoneClient;

    public TelefoneDTOResponse updateTelefone(Long id, TelefoneDTORequest telefoneDTORequest, String token) {
        return telefoneClient.updateTelefone(telefoneDTORequest, id, token);
    }

    public TelefoneDTOResponse saveTelefone(TelefoneDTORequest telefoneDTORequest, String token) {
        return telefoneClient.saveTelefone(telefoneDTORequest, token);
    }
}
