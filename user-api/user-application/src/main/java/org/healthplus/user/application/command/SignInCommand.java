package org.healthplus.user.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInCommand {

  private String email;
  private String password;

}
