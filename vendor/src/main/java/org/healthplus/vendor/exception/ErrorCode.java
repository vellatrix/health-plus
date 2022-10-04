package org.healthplus.vendor.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /* 400 BAD_REQUEST */
  /* 404 NOT_FOUND */
  INVALID_VENDOR(NOT_FOUND, "존재하지 않는 판매회원입니다."),

  /* 500 SERVER_ERROR */
  MENU_MODIFICATION_FAIL(NOT_IMPLEMENTED, "메뉴 변경이 실패되었습니다."),
  MENU_OPTION_UPDATE_FAIL(NOT_IMPLEMENTED, "메뉴 옵션 변경이 실패되었습니다."),
  VENDOR_REMOVAL_FAIL(NOT_IMPLEMENTED, "판매회원 탈퇴가 실패되었습니다.")
  ;


  private final HttpStatus httpStatus;
  private final String message;
}
