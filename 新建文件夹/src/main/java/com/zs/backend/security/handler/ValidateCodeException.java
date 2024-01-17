package com.zs.backend.security.handler;

import org.springframework.security.core.AuthenticationException;


public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String message) {
        super(message);
    }
}
