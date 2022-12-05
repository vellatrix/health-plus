package org.healthplus.account.domain.exception;

public class PasswordMisMatchException extends IllegalArgumentException{

  public PasswordMisMatchException() {
    super();
  }

  public PasswordMisMatchException(String s) {
    super(s);
  }
}
