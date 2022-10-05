package org.healthplus.vendor.enums;

import lombok.Getter;

@Getter
public enum Category {

  FISH(1L), SALAD(2L);

  private Long id;

  Category(Long id) {
    this.id = id;
  }

}
