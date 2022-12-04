package org.healthplus.account.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.healthplus.model.role.Role;

@Getter
@AllArgsConstructor
public class SignupCommand {

  private String email;
  private String password;
  private String name;
  private String phoneNumber;
  private Role role;

}
