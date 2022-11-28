package org.healthplus.shop.domain.exception;

public class OptionGroupNotFoundException extends RuntimeException {

  public OptionGroupNotFoundException() {
    super("존재하지 않는 메뉴 옵션입니다.");
  }

}
