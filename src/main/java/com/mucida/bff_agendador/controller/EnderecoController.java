package com.mucida.bff_agendador.controller;

import com.mucida.bff_agendador.bussines.EnderecoService;
import com.mucida.bff_agendador.bussines.dto.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/endereco")
@Tag(name = "Endereço", description = "Cadastro e atualização de endereços de usuários")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PutMapping
    @Operation(summary = "Atualiza endereço de usuários", description = "Atualiza endereço de usuários")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> updateEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                                      @RequestParam Long id,
                                                      @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(enderecoService.updateEndereco(id, enderecoDTO, token));
    }

    @PostMapping
    @Operation(summary = "Salva endereço de usuários", description = "Salva endereço de usuários")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> saveEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                                    @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(enderecoService.saveEndereco(enderecoDTO, token));
    }

}
