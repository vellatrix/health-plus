package org.healthplus.deliveryworker.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class DeliveryWorkerControllerAdvice {

  @ExceptionHandler(value = {DeliveryWorkerException.class})
  protected ResponseEntity<ErrorResponse> handleDeliveryWorkerException(
      DeliveryWorkerException e) {
    log.error("DeliveryWorkerException Code : {} - Message : {}",
        e.getErrorCode().getHttpStatus(), e.getErrorCode().getMessage());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }

}
