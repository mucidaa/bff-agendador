package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO findByEmail(@RequestParam("email") String email,
                           @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTO saveUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deleteByEmail(@PathVariable String email,
                       @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTO updateUsuario(@RequestBody UsuarioDTO usuarioDTO,
                             @RequestHeader("Authorization") String token);
}
