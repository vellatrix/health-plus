package org.healthplus.vendor.util;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Response {

  private String trace;
  private String message;
  private HttpStatus status;
  private LocalDateTime timestamp;
  private Object data;

  @Builder
  public Response(String message, HttpStatus status, Object data) {
    this.trace = UUID.randomUUID().toString().replace("-", "");
    this.timestamp = LocalDateTime.now();
    this.message = message;
    this.status = status;
    this.data = data;
  }
}
