package org.healthplus.shop.domain.vendor;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class UserId {

  private Long userId;

  public UserId(Long userId) {
    this.userId = userId;
  }
}
