package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.request.TarefaDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TarefaDTOResponse;
import com.mucida.bff_agendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailClient emailClient;

    public void sendEmail(TarefaDTOResponse tarefaDTOResponse) {
        emailClient.sendEmail(tarefaDTOResponse);
    }
}
