package org.healthplus.user.application.command;

import lombok.Getter;

@Getter
public class SignInCommand {

  private String email;
  private String password;

  public SignInCommand(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
