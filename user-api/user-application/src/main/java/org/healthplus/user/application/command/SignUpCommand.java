package org.healthplus.user.application.command;

import lombok.Getter;

@Getter
public class SignUpCommand {

  private String email;
  private String password;
  private String nickName;
  private String phoneNumber;

  public SignUpCommand(String email, String password, String nickName, String phoneNumber) {
    this.email = email;
    this.password = password;
    this.nickName = nickName;
    this.phoneNumber = phoneNumber;
  }
}
