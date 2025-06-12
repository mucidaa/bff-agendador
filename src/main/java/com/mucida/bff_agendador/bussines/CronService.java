package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.request.LoginDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TarefaDTOResponse;
import com.mucida.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefaService tarefaService;
    private final UsuarioService usuarioService;
    private final EmailService emailService;

    @Value("${admin.email}")
    private String email;

    @Value("${admin.senha}")
    private String senha;

    @Scheduled(cron = "${cron.timer}")
    public void findTarefasNextHour() {
        List<TarefaDTOResponse> listaTarefas;
        listaTarefas = tarefaService.findByDataEventoBetween(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        listaTarefas.forEach( tarefa -> {
            if (tarefa.getStatus() == StatusNotificacaoEnum.PENDENTE) {
                emailService.sendEmail(tarefa);
                tarefaService.updateStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), login());
            }
        });
    }

    private String login() {
        return usuarioService.login(new LoginDTORequest(email, senha));
    }
}
