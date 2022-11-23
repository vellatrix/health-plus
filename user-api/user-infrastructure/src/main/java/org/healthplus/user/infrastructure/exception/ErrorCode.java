package org.healthplus.user.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  /* JWT 관련 Exception Message */
  JWT_ALGORITHM_NAME_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "JWT 알고리즘을 정확히 해야합니다."),
  TOKEN_TYPE_NAME_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "JWT Token 타입이 아닙니다."),
  Encode_Exception(HttpStatus.NOT_ACCEPTABLE, "Encode Exception"),

  /* User 관련 Exception Message */
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "계정이 존재하지 않습니다.");


  private final HttpStatus httpStatus;
  private final String message;
}
