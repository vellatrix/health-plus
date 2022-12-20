package org.healthplus.account.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.healthplus.model.role.Role;

@Getter
@AllArgsConstructor
public class SessionValueVO {

  private Long userId;
  private String email;
  private Role role;

}
