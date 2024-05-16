package com.prueba.demo.infrastructure.entrypoint.exceptionhandler;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}
