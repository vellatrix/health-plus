package org.healthplus.vendor.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /* 400 BAD_REQUEST */
  INVALID_VENDOR(BAD_REQUEST, "존재하지 않는 판매회원입니다."),
  INVALID_RESTAURANT(BAD_REQUEST, "존재하지 않는 식당입니다."),
  INVALID_MENU(BAD_REQUEST, "존재하지 않는 메뉴입니다."),
  EMPTY_MENU(BAD_REQUEST, "등록할 메뉴가 없습니다."),
  /* 404 NOT_FOUND */


  /* 500 SERVER_ERROR */
  MENU_MODIFICATION_FAIL(NOT_IMPLEMENTED, "메뉴 변경이 실패되었습니다."),
  MENU_OPTION_GROUP_UPDATE_FAIL(NOT_IMPLEMENTED, "메뉴 옵션 그룹 변경이 실패되었습니다."),
  MENU_OPTION_DETAIL_UPDATE_FAIL(NOT_IMPLEMENTED, "메뉴 상세 옵션 변경이 실패되었습니다."),
  MENU_REMOVAL_FAIL(NOT_IMPLEMENTED, "메뉴 삭제가 실패되었습니다."),
  VENDOR_REMOVAL_FAIL(NOT_IMPLEMENTED, "판매회원 탈퇴가 실패되었습니다.")
  ;


  private final HttpStatus httpStatus;
  private final String message;
}
