package org.healthplus.shop.domain.exception;

public class OptionNotFoundException extends RuntimeException {

  public OptionNotFoundException() {
    super("존재하지 않는 옵션입니다.");
  }

}
