package org.healthplus.account.domain;

import org.healthplus.model.role.Role;

public class SessionValueVO {

  private Long userId;
  private String email;
  private Role role;

  public SessionValueVO(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
  }
}
