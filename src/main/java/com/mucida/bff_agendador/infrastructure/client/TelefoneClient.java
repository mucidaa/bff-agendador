package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.TelefoneDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "telefone", url = "${telefone.url}")
public interface TelefoneClient {

    @PutMapping
    TelefoneDTO updateTelefone(@RequestBody TelefoneDTO telefoneDTO,
                               @RequestParam Long id,
                               @RequestHeader("Authorization") String token);

    @PostMapping
    TelefoneDTO saveTelefone(@RequestBody TelefoneDTO telefoneDTO,
                            @RequestHeader("Authorization") String token);
}
