package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.UsuarioDTO;
import com.mucida.bff_agendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.saveUsuario(usuarioDTO);
    }

    public String login(UsuarioDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO, String token) {
        return usuarioClient.updateUsuario(usuarioDTO, token);
    }

    public UsuarioDTO findByEmail(String email, String token) {
        return usuarioClient.findByEmail(email, token);
    }

    public void deleteByEmail(String email, String token) {
        usuarioClient.deleteByEmail(email, token);
    }

}
