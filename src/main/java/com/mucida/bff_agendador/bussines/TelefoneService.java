package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.TelefoneDTO;
import com.mucida.bff_agendador.infrastructure.client.TelefoneClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TelefoneService {

    private final TelefoneClient telefoneClient;

    public TelefoneDTO updateTelefone(Long id, TelefoneDTO telefoneDTO, String token) {
        return telefoneClient.updateTelefone(telefoneDTO, id, token);
    }

    public TelefoneDTO saveTelefone(TelefoneDTO telefoneDTO, String token) {
        return telefoneClient.saveTelefone(telefoneDTO, token);
    }
}
