package com.mucida.bff_agendador.infrastructure.exceptions;

import javax.security.sasl.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {
    public UnauthorizedException(String message) {
        super(message);
    }
  public UnauthorizedException(String message, Throwable cause) {
    super(message, cause);
  }
}
