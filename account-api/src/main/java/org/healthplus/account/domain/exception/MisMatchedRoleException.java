package org.healthplus.account.domain.exception;

public class MisMatchedRoleException extends RuntimeException {

  public MisMatchedRoleException() {
    super();
  }

  public MisMatchedRoleException(String message) {
    super(message);
  }
}
