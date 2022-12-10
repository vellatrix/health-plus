package org.healthplus.account.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  TOKEN_SIGNATURE_ALGORITHM_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "JWT ALGORITHM 타입이 아닙니다."),
  TOKEN_HEADER_TYPE_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "JWT HEADER 타입이 아닙니다."),
  SIGNATURE_ENCRYPT_EXCEPTION(HttpStatus.NOT_FOUND, "암호화가 정상적으로 처리되지 않습니다.");


  private final HttpStatus httpStatus;
  private final String message;
}
