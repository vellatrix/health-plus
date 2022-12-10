package org.healthplus.account.infrastructure.exception;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class ErrorResponse {

  private final Instant timeStamp;
  private final int status;
  private final String message;

  @Builder
  public ErrorResponse(Instant timeStamp, int status, String message) {
    this.timeStamp = timeStamp;
    this.status = status;
    this.message = message;
  }

  public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
    return ResponseEntity.status(errorCode.getHttpStatus())
        .body(ErrorResponse.builder()
            .timeStamp(Instant.now())
            .status(errorCode.getHttpStatus().value())
            .message(errorCode.getMessage())
            .build()
        );
  }
}
