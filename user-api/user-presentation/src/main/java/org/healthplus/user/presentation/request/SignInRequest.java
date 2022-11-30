package org.healthplus.user.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.user.application.command.SignInCommand;

@Getter
@NoArgsConstructor
public class SignInRequest {

  private String email;
  private String password;

  /*
  * SignInRequest -> SignInCommand
  * */
  public SignInCommand toCommand() {
    return new SignInCommand(
        this.email,
        this.password
    );
  }
}
