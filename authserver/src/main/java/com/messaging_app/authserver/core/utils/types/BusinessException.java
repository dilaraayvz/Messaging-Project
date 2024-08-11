package com.messaging_app.authserver.core.utils.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
