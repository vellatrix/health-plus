package org.healthplus.account.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SigninCommand {

  private String email;
  private String password;

}
