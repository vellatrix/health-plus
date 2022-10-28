package org.healthplus.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransactionException;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
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
  @ExceptionHandler(value = { SQLException.class, TransactionException.class, DataAccessException.class })
  protected ResponseEntity<ErrorResponse> handleDatabaseException(Exception e) {
    log.error("DatabaseException Message : {}", e.getMessage());
    return ErrorResponse.toResponseEntity(HttpStatus.NOT_IMPLEMENTED, "데이터베이스 오류 발생");
  }

  @Order(3)
  @ExceptionHandler(value = Exception.class)
  protected ResponseEntity<ErrorResponse> handleException(Exception e) {
    log.error("Exception Message : {}", e.getMessage());
    return ErrorResponse.toResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러 발생");
  }
}
