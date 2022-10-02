package org.healthplus.vendor.exception;

public class MenuModificationFailException extends Exception{

  public MenuModificationFailException() {
    super("메뉴 정보 갱신이 실패되었습니다.");
  }
}
