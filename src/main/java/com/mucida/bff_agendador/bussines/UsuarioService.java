package com.mucida.bff_agendador.bussines;

import com.mucida.bff_agendador.bussines.dto.request.LoginDTORequest;
import com.mucida.bff_agendador.bussines.dto.request.UsuarioDTORequest;
import com.mucida.bff_agendador.bussines.dto.response.UsuarioDTOResponse;
import com.mucida.bff_agendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse saveUsuario(UsuarioDTORequest usuarioDTORequest) {
        return usuarioClient.saveUsuario(usuarioDTORequest);
    }

    public String login(LoginDTORequest loginDTORequest) {
        return usuarioClient.login(loginDTORequest);
    }

    public UsuarioDTOResponse updateUsuario(UsuarioDTORequest usuarioDTORequest, String token) {
        return usuarioClient.updateUsuario(usuarioDTORequest, token);
    }

    public UsuarioDTOResponse findByEmail(String email, String token) {
        return usuarioClient.findByEmail(email, token);
    }

    public void deleteByEmail(String email, String token) {
        usuarioClient.deleteByEmail(email, token);
    }

}
