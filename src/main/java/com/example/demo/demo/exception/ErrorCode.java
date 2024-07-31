package com.example.demo.demo.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 추월 순서가 잘못됐을 경우
    FIRST_PLAYER(200,  "첫번째 선수는 추월을 할 수 없습니다."),

    // 추월 이름이 선수 명단에 없는 경우
    WORNG_PLAYER(200, "선수 명단에 없는 이름입니다.");

    // 에러 코드의 '코드 상태' 반환
    private final int status;
    // 에러 코드의 '코드 메시지' 반환
    private final String message;

    ErrorCode(final int status, final String message){
        this.status = status;
        this. message = message;
    }
}
