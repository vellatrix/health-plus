package org.healthplus.shop.domain;

import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

import java.time.LocalDateTime;

@Getter
public class ShopCategoryDomain {

  private Integer id;
  private String type;
  private LocalDateTime createdAt;
  private IsYn useYn;

  public ShopCategoryDomain(Integer id) {
    this.id = id;
  }
}
