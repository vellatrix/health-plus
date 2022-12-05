package org.healthplus.account.application.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.account.domain.User;
import org.healthplus.model.role.Role;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResult {

  private Long id;
  private String name;
  private String email;
  private String phoneNumber;
  private Role role;

  private String token;

  public static AccountResult fromUser(User user) {
    return new AccountResult(
        user.getId(),
        user.getEmail(),
        user.getName(),
        user.getPhoneNumber(),
        user.getRole()
    );
  }

  /*
  * return Controller to Client
  * */
  public AccountResult(Long id, String name, String email, String phoneNumber, Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.role = role;
  }

  public void addToken(String givenToken) {
    this.token = givenToken;
  }
}
