package com.mucida.bff_agendador.infrastructure.client.config;

import com.mucida.bff_agendador.infrastructure.exceptions.BusinessException;
import com.mucida.bff_agendador.infrastructure.exceptions.ConflictException;
import com.mucida.bff_agendador.infrastructure.exceptions.ResourceNotFoundException;
import com.mucida.bff_agendador.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String errorMessage = errorMessage(response);

        switch (response.status()){
            case 409:
                return new ConflictException("Erro: " + errorMessage);
            case 403:
                return new ResourceNotFoundException("Erro: " + errorMessage);
            case 401:
                return new UnauthorizedException("Erro: " + errorMessage);
            case 400:
                return new IllegalArgumentException("Erro: " + errorMessage);
            default:
                return new BusinessException("Erro: " + errorMessage);

        }
    }

    private String errorMessage(Response response) {
        try {
            if (Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
