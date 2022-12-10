package org.healthplus.account.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.model.role.Role;

@Getter
@NoArgsConstructor
public class TokenPayloadVo {

  private Long userId;
  private String email;
  private Role role;
  // private Instant instant;

  public TokenPayloadVo(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
    // this.instant = Instant.now();
  }
}
