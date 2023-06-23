package com.ifutsalu.handler;

import com.ifutsalu.dto.response.CMRespDto;
import com.ifutsalu.exception.CustomException;
import com.ifutsalu.exception.CustomValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getErrorCode().getMessage(), null), e.getErrorCode().getStatus());
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> handleCustomValidationException(CustomValidationException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }
}
