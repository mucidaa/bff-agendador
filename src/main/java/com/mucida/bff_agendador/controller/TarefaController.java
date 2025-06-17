package com.mucida.bff_agendador.controller;

import com.mucida.bff_agendador.bussines.TarefaService;
import com.mucida.bff_agendador.bussines.dto.request.TarefaDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.TarefaDTOResponse;
import com.mucida.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.mucida.bff_agendador.infrastructure.security.SecurityConfig.SECURITY_SCHEME;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefa")
@Tag(name = "Tarefa", description = "CRUD de tarefas")
@SecurityRequirement(name = SECURITY_SCHEME)
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Salvar Tarefas", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<TarefaDTOResponse> saveTarefa(@RequestBody TarefaDTORequest tarefaDTORequest,
                                                        @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.saveTarefa(tarefaDTORequest, token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca lista de tarefas por período", description = "Busca tarefas cadastradas por um período")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefaDTOResponse>> findByDataEventoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime firstDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate) {
        return ResponseEntity.ok(tarefaService.findByDataEventoBetween(firstDate, finalDate));
    }

    @GetMapping
    @Operation(summary = "Busca lista de tarefas por email", description = "Busca tarefas cadastradas por email")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Email não encontrado")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<List<TarefaDTOResponse>> findByEmailUsuario(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.findByEmailUsuario(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por Id", description = "Deleta tarefas cadastradas por Id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa id não encontrada")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<Void> deleteById(@RequestParam("id") String id,
                                           @RequestHeader(name = "Authorization", required = false) String token) {
        tarefaService.deleteById(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status da tarefa", description = "Altera status da tarefa por Id")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa id não encontrada")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<TarefaDTOResponse> updateStatus(@RequestParam("status") StatusNotificacaoEnum status,
                                                          @RequestParam("id") String id,
                                                          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.updateStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados da tarefa", description = "Altera dados da tarefa por Id")
    @ApiResponse(responseCode = "200", description = "Tarefa alterada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa id não encontrada")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<TarefaDTOResponse> updateTarefa(@RequestBody TarefaDTORequest tarefaDTORequest,
                                                          @RequestParam("id") String id,
                                                          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.updateTarefa(tarefaDTORequest, id, token));
    }
}
