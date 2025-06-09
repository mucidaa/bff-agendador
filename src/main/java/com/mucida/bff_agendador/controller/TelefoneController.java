package com.mucida.bff_agendador.controller;

import com.mucida.bff_agendador.bussines.TelefoneService;
import com.mucida.bff_agendador.bussines.dto.TelefoneDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/telefone")
@Tag(name = "Telefone", description = "Cadastro e atualização de telefones de usuários")
public class TelefoneController {

    private final TelefoneService telefoneService;

    @PutMapping
    @Operation(summary = "Atualiza telefone de usuários", description = "Atualiza telefone de usuários")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> updateTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                      @RequestParam Long id,
                                                      @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(telefoneService.updateTelefone(id, telefoneDTO, token));
    }

    @PostMapping
    @Operation(summary = "Salva telefone de usuários", description = "Salva telefone de usuários")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> saveTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                    @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(telefoneService.saveTelefone(telefoneDTO, token));
    }
}
