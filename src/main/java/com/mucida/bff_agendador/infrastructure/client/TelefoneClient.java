package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.request.TelefoneDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TelefoneDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "telefone", url = "${telefone.url}")
public interface TelefoneClient {

    @PutMapping
    TelefoneDTOResponse updateTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                       @RequestParam Long id,
                                       @RequestHeader("Authorization") String token);

    @PostMapping
    TelefoneDTOResponse saveTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                     @RequestHeader("Authorization") String token);
}
