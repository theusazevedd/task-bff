package com.azevedo.task_bff.insfrastructure.exceptions;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String mensagem) {
        super(mensagem);

    }

    public UnauthorizedException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
