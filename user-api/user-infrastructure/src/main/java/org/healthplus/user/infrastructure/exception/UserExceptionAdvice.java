package org.healthplus.user.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserExceptionAdvice {

    @ExceptionHandler(value = UserException.class)
    protected ResponseEntity<ErrorResponse> handleUserException(UserException e) {
        log.error("UserException Code : {} - Message : {}", e.getErrorCode().getHttpStatus(),
            e.getErrorCode().getMessage());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
