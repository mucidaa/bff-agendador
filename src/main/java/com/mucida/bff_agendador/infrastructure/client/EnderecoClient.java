package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.request.EnderecoDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.EnderecoDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "endereco", url = "${endereco.url}")
public interface EnderecoClient {

    @PutMapping
    EnderecoDTOResponse updateEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                       @RequestParam Long id,
                                       @RequestHeader("Authorization") String token);

    @PostMapping
    EnderecoDTOResponse saveEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                     @RequestHeader("Authorization") String token);
}
