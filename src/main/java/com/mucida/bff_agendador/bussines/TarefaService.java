package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.request.TarefaDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TarefaDTOResponse;
import com.mucida.bff_agendador.infrastructure.client.TarefaClient;
import com.mucida.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TarefaService {

    private final TarefaClient tarefaClient;

    public TarefaDTOResponse saveTarefa(TarefaDTORequest tarefaDTORequest, String token) {
        return tarefaClient.saveTarefa(tarefaDTORequest, token);
    }

    public List<TarefaDTOResponse> findByDataEventoBetween(LocalDateTime firstDate, LocalDateTime finalDate) {
        return tarefaClient.findByDataEventoBetween(firstDate, finalDate);
    }

    public List<TarefaDTOResponse> findByEmailUsuario(String token) {
        return tarefaClient.findByEmailUsuario(token);
    }

    public void deleteById(String id, String token) {
        tarefaClient.deleteById(id, token);
    }

    public TarefaDTOResponse updateStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefaClient.updateStatus(status, id, token);
    }

    public TarefaDTOResponse updateTarefa(TarefaDTORequest tarefaDTORequest, String id, String token) {
        return tarefaClient.updateTarefa(tarefaDTORequest, id, token);
    }
}
