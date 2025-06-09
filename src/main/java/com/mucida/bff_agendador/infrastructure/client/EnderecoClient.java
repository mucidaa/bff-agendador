package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "endereco", url = "${endereco.url}")
public interface EnderecoClient {

    @PutMapping
    EnderecoDTO updateEndereco(@RequestBody EnderecoDTO enderecoDTO,
                               @RequestParam Long id,
                               @RequestHeader("Authorization") String token);

    @PostMapping
    EnderecoDTO saveEndereco(@RequestBody EnderecoDTO enderecoDTO,
                             @RequestHeader("Authorization") String token);
}
