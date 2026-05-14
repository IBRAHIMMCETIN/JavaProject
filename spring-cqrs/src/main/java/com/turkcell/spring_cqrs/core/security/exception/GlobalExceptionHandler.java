package com.turkcell.spring_cqrs.core.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // HTTP 401 döner
    public String handleAuthenticationError(AuthenticatedException authenticatedException) {
        return authenticatedException.getMessage();
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) // HTTP 403 döner
    public String handleAuthorizationError(AuthorizationException authorizationException) {
        return authorizationException.getMessage();
    }
}