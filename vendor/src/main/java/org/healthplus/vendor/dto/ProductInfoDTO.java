package org.healthplus.vendor.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductInfoDTO {

  private String name;
  private Integer price;
  private Integer calorie;
  private LocalDateTime modifiedAt;
  private ProductOptionGroupInfoDTO optionGroup;
}
