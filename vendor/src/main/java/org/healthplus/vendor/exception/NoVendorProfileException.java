package org.healthplus.vendor.exception;

public class NoVendorProfileException extends Exception {

  public NoVendorProfileException() {
    super("존재하지 않는 판매회원입니다.");
  }
}
