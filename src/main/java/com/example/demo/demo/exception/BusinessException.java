package com.example.demo.demo.exception;

import lombok.Getter;

/**
 * Service에서 발생하는 비즈니스 로직 에러
 */
public class BusinessException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
}
