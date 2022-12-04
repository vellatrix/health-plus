package org.healthplus.account.domain.exception;

public class EmailInfoMisMatchException extends IllegalArgumentException {

  public EmailInfoMisMatchException() {
  }

  public EmailInfoMisMatchException(String s) {
    super(s);
  }
}
