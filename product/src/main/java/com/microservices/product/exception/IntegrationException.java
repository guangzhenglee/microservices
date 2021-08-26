package com.microservices.product.exception;

public class IntegrationException extends RuntimeException{
    public IntegrationException(String message) {
        super(message);
    }
}
