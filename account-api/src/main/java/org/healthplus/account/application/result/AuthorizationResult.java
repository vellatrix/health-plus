package org.healthplus.account.application.result;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.healthplus.account.domain.vo.SessionValueVO;
import org.healthplus.model.role.Role;

/*
* 인가를 위한 값, 값이 변경되면 안되기에 property에 final을 붙여 사용
* */
public class AuthorizationResult {

  private final Long userId;
  private final String email;
  private final Role role;

  public AuthorizationResult(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
  }

  public Role getCurrentRole() {
    return this.role;
  }

  public static AuthorizationResult fromSessionValue(SessionValueVO sessionValueVO) {
    return new AuthorizationResult(
        sessionValueVO.getUserId(),
        sessionValueVO.getEmail(),
        sessionValueVO.getRole()
    );
  }
}
