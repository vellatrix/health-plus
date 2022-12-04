package org.healthplus.account.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.account.application.command.SigninCommand;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInRequest {

  private String email;
  private String password;

  public SigninCommand toCommand() {
    return new SigninCommand(
        this.email,
        this.password
    );
  }
}
