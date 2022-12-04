package org.healthplus.shop.domain.exception;

public class VendorNotFoundException extends RuntimeException{

  public VendorNotFoundException() {
    super("존재하지 않는 판매회원입니다.");
  }
}
