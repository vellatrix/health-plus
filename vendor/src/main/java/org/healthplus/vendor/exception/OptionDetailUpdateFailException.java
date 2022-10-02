package org.healthplus.vendor.exception;

public class OptionDetailUpdateFailException extends Exception {

  public OptionDetailUpdateFailException() {
    super("메뉴 옵션 정보 갱신이 실패되었습니다.");
  }
}
