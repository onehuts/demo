package com.example.demo.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.demo.dto.RaceResponseDto;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public RaceResponseDto handleBuisinessException(BusinessException e){
        
        final RaceResponseDto responseDto = new RaceResponseDto();
        responseDto.setResult(e.getErrorCode().getMessage());
        return responseDto;
    }
}
