package org.healthplus.shop.application.exception;

public class MenuNotFoundException extends RuntimeException{

  public MenuNotFoundException() {
    super("존재하지 않는 메뉴입니다.");
  }
}
