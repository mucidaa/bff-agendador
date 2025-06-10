package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.request.TarefaDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TarefaDTOResponse;
import com.mucida.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "tarefa", url = "${tarefa.url}")
public interface TarefaClient {

    @PostMapping
    TarefaDTOResponse saveTarefa(@RequestBody TarefaDTORequest tarefaDTORequest,
                                 @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefaDTOResponse> findByDataEventoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime firstDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate);

    @GetMapping()
    List<TarefaDTOResponse> findByEmailUsuario(@RequestHeader("Authorization") String token);

    @DeleteMapping()
    void deleteById(@RequestParam("id") String id,
                    @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefaDTOResponse updateStatus(@RequestParam("status") StatusNotificacaoEnum status,
                                   @RequestParam("id") String id,
                                   @RequestHeader("Authorization") String token);

    @PutMapping
    TarefaDTOResponse updateTarefa(@RequestBody TarefaDTORequest tarefaDTORequest,
                                   @RequestParam("id") String id,
                                   @RequestHeader("Authorization") String token);
}
