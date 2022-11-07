package org.healthplus.user.domain.exception;

public class UserExistException extends IllegalArgumentException {

  public UserExistException() {
  }

  public UserExistException(String s) {
    super(s);
  }
}
