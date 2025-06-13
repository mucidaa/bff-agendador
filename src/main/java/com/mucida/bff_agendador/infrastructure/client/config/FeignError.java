package com.mucida.bff_agendador.infrastructure.client.config;

import com.mucida.bff_agendador.infrastructure.exceptions.BusinessException;
import com.mucida.bff_agendador.infrastructure.exceptions.ConflictException;
import com.mucida.bff_agendador.infrastructure.exceptions.ResourceNotFoundException;
import com.mucida.bff_agendador.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Erro servidor");

        }
    }
}
