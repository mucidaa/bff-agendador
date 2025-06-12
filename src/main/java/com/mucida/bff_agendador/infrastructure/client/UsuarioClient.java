package com.mucida.bff_agendador.infrastructure.client;

import com.mucida.bff_agendador.bussines.dto.request.LoginDTORequest;
import com.mucida.bff_agendador.bussines.dto.request.UsuarioDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse findByEmail(@RequestParam("email") String email,
                                   @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse saveUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest loginDTORequest);

    @DeleteMapping("/{email}")
    void deleteByEmail(@PathVariable String email,
                       @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse updateUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest,
                                     @RequestHeader("Authorization") String token);
}
