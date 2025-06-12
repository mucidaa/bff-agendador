package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.response.TarefaDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email", url = "${email.url}")
public interface EmailClient {

    @PostMapping
    void sendEmail(@RequestBody TarefaDTOResponse tarefaDTOResponse);

}
