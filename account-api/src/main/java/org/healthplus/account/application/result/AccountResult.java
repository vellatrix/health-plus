package org.healthplus.account.application.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.account.domain.entity.User;
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

  public static AccountResult fromUser(User user) {
    return new AccountResult(
        user.getId(),
        user.getEmail(),
        user.getName(),
        user.getPhoneNumber(),
        user.getRole()
    );
  }
}
