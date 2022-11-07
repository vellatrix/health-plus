package org.healthplus.domain.exception;

public class UserExistException extends IllegalArgumentException {

  public UserExistException() {
  }

  public UserExistException(String s) {
    super(s);
  }
}
