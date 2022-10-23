package org.healthplus.vendor.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ProductOptionDetailInfoDTO {

  private Long optionDetailId;
  private String name;
  private Integer price;

  @QueryProjection
  public ProductOptionDetailInfoDTO(Long optionDetailId, String name, Integer price) {
    this.optionDetailId = optionDetailId;
    this.name = name;
    this.price = price;
  }

  public ProductOptionDetailInfoDTO(String name, Integer price) {
    this.name = name;
    this.price = price;
  }
}
