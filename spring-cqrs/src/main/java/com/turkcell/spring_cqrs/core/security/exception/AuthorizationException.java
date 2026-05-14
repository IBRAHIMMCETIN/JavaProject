package com.turkcell.spring_cqrs.core.security.exception;

public class AuthorizationException extends RuntimeException {
    
    private String hataMesaji;

    public AuthorizationException(String hataMesaji) {
        this.hataMesaji = hataMesaji;
    }

    @Override
    public String getMessage() {
        return this.hataMesaji;
    }
}