package org.healthplus.user.infrastructure.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponse {

  private final LocalDateTime timeStamp;
  private final int status;
  private final String message;

  public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
    return ResponseEntity
        .status(errorCode.getHttpStatus())
        .body(ErrorResponse.builder()
            .timeStamp(LocalDateTime.now())
            .status(errorCode.getHttpStatus().value())
            .message(errorCode.getMessage())
            .build()
        );
  }

}
