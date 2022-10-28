package org.healthplus.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /* 400 BAD_REQUEST */
  INVALID_CUSTOMER(BAD_REQUEST, "존재하지 않는 구매회원입니다."),
  /* 404 NOT_FOUND */

  /* 500 SERVER_ERROR */
  CUSTOMER_REMOVAL_FAIL(NOT_IMPLEMENTED, "구매회원 탈퇴가 실패되었습니다.")
  ;


  private final HttpStatus httpStatus;
  private final String message;
}
