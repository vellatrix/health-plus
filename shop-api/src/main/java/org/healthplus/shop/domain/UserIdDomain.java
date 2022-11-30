package org.healthplus.shop.domain;

import lombok.Getter;

@Getter
public class UserIdDomain {

  private Long userId;

  public UserIdDomain(Long userId) {
    this.userId = userId;
  }
}
