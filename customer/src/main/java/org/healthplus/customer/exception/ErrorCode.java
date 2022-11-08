package org.healthplus.customer.exception;

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
  EXISTING_ID(BAD_REQUEST, "이미 존재하는 ID입니다."),
  EXISTING_NICKNAME(BAD_REQUEST, "이미 존재하는 닉네임입니다."),
  EXISTING_EMAIL(BAD_REQUEST, "이미 존재하는 이메일입니다."),
  EXISTING_PHONE_NUMBER(BAD_REQUEST, "이미 존재하는 전화번호입니다."),
  /* 404 NOT_FOUND */

  /* 500 SERVER_ERROR */
  CUSTOMER_REMOVAL_FAIL(NOT_IMPLEMENTED, "구매회원 탈퇴가 실패되었습니다.")
  ;


  private final HttpStatus httpStatus;
  private final String message;
}
