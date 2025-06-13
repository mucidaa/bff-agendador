package com.mucida.bff_agendador.controller;

import com.mucida.bff_agendador.bussines.UsuarioService;
import com.mucida.bff_agendador.bussines.dto.request.LoginDTORequest;
import com.mucida.bff_agendador.bussines.dto.request.UsuarioDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.UsuarioDTOResponse;
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
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
@SecurityRequirement(name = SECURITY_SCHEME)
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar Usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "409", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> saveUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuarioDTORequest));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de Usuários", description = "Faz login e retorna token de autenticação")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<String> login(@RequestBody LoginDTORequest loginDTORequest) {
        return ResponseEntity.ok(usuarioService.login(loginDTORequest));
    }

    @GetMapping
    @Operation(summary = "Buscar dado de um usuário por email",
            description = "Busca dados do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> findByEmail(@RequestParam("email") String email,
                                                          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.findByEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta usuários", description = "Deleta usuário por email(id)")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<Void> deleteByEmail(@PathVariable String email,
                                              @RequestHeader(name = "Authorization", required = false) String token) {
        usuarioService.deleteByEmail(email, token);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Operation(summary = "Atualiza dados de um usuário",
            description = "Atualiza dados de um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> updateUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.updateUsuario(usuarioDTORequest, token));
    }

}
