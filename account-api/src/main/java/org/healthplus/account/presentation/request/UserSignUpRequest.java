package org.healthplus.account.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.account.application.command.SignupCommand;
import org.healthplus.model.role.Role;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequest {

  private String email;
  private String password;
  private String name;
  private String phoneNumber;
  private Role role;

  public SignupCommand toCommand() {
    return new SignupCommand(
        this.email,
        this.password,
        this.name,
        this.phoneNumber,
        this.role);
  }
}
