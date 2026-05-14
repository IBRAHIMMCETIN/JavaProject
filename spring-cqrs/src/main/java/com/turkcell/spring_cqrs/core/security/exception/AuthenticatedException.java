package com.turkcell.spring_cqrs.core.security.exception;

public class AuthenticatedException extends RuntimeException {
    
    private String hataMesaji;

    public AuthenticatedException(String hataMesaji) {
        this.hataMesaji = hataMesaji;
    }

    @Override
    public String getMessage() {
        return this.hataMesaji;
    }
}