package org.healthplus.vendor.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

  private final LocalDateTime timestamp;
  private final int status;
  private final String message;

  public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
    return ResponseEntity
            .status(errorCode.getHttpStatus())
            .body(ErrorResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .status(errorCode.getHttpStatus().value())
                    .message(errorCode.getMessage())
                    .build()
            );
  }

  public static ResponseEntity<ErrorResponse> toResponseEntity(HttpStatus status, String message) {
    return ResponseEntity
            .status(status)
            .body(ErrorResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .status(status.value())
                    .message(message)
                    .build()
            );
  }
}
