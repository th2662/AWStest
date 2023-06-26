package com.ifutsalu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    BAD_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    // stadium
    NOT_FOUND_STADIUM(HttpStatus.NOT_FOUND, "해당 구장을 찾을 수 없습니다."),

    // review
    NOT_FOUND_REVIEW(HttpStatus.NOT_FOUND, "해당 리뷰를 찾을 수 없습니다."),

    // match
    NOT_FOUND_MATCH(HttpStatus.NOT_FOUND, "해당 매치를 찾을 수 없습니다."),

    // user
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),
    FORBIDDEN_MEMBER(HttpStatus.FORBIDDEN, "해당 요청에 권한이 없습니다.");

    private final HttpStatus status;
    private final String message;
}
