package com.mucida.bff_agendador.controller;

import com.mucida.bff_agendador.bussines.EnderecoService;
import com.mucida.bff_agendador.bussines.dto.request.EnderecoDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.EnderecoDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mucida.bff_agendador.infrastructure.security.SecurityConfig.SECURITY_SCHEME;

@RestController
@RequiredArgsConstructor
@RequestMapping("/endereco")
@Tag(name = "Endereço", description = "Cadastro e atualização de endereços de usuários")
@SecurityRequirement(name = SECURITY_SCHEME)
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PutMapping
    @Operation(summary = "Atualiza endereço de usuários", description = "Atualiza endereço de usuários")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoDTOResponse> updateEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                                              @RequestParam Long id,
                                                              @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(enderecoService.updateEndereco(id, enderecoDTORequest, token));
    }

    @PostMapping
    @Operation(summary = "Salva endereço de usuários", description = "Salva endereço de usuários")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoDTOResponse> saveEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(enderecoService.saveEndereco(enderecoDTORequest, token));
    }

}
