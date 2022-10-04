package org.healthplus.vendor.enums;

import lombok.Getter;

@Getter
public enum Category {

  FISH(1L), SALAD(2L);

  private Long id;

  Category(Long id) {
    this.id = id;
  }

  public static Long selectCategoryId(String type) {
    for (Category value : Category.values()) {
      if(type.equalsIgnoreCase(value.name())) {
        return value.getId();
      }
    }

    return 0L;
  }

  public static String selectCategoryName(Long id) {
    for(Category value : Category.values()) {
      if(id == value.getId()) {
        return value.name();
      }
    }

    return "None";
  }
}
