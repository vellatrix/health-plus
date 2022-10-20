package org.healthplus.vendor.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

  @Order(1)
  @ExceptionHandler(value = { CustomException.class })
  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    log.error("CustomException Code : {} - Message : {}", e.getErrorCode().getHttpStatus(), e.getMessage());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }

  @Order(2)
  @ExceptionHandler(value = Exception.class)
  protected ResponseEntity<ErrorResponse> handleException(Exception e) {
    return ErrorResponse.toResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
  }
}
