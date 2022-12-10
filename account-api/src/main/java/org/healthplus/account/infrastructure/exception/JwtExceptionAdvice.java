package org.healthplus.account.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class JwtExceptionAdvice {


  @ExceptionHandler(value = JwtException.class)
  protected ResponseEntity<ErrorResponse> handleJwtException(JwtException e) {
    log.error("JwtException Code : {} - Message : {}", e.getErrorCode().getHttpStatus(),
        e.getErrorCode().getMessage());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }
}
