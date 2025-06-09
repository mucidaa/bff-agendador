package com.mucida.bff_agendador.controller;

import com.mucida.bff_agendador.bussines.UsuarioService;
import com.mucida.bff_agendador.bussines.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar Usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de Usuários", description = "Faz login e retorna token de autenticação")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.login(usuarioDTO));
    }

    @GetMapping
    @Operation(summary = "Buscar dado de um usuário por email",
            description = "Busca dados do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> findByEmail(@RequestParam("email") String email,
                                                  @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(usuarioService.findByEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta usuários", description = "Deleta usuário por email(id)")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deleteByEmail(@PathVariable String email,
                                              @RequestHeader("Authorization") String token) {
        usuarioService.deleteByEmail(email, token);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Operation(summary = "Atualiza dados de um usuário",
            description = "Atualiza dados de um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuarioDTO,
                                                    @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(usuarioService.updateUsuario(usuarioDTO, token));
    }

}
