package org.healthplus.vendor.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductInfoByCategoryDTO {

  private Long menuId;
  private Long categoryId;
  private String name;
  private Integer price;
  private Integer stock;
  private String description;

  @QueryProjection
  public ProductInfoByCategoryDTO(Long menuId,
                                  Long categoryId,
                                  String name,
                                  Integer price,
                                  Integer stock,
                                  String description) {
    this.menuId = menuId;
    this.categoryId = categoryId;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.description = description;
  }
}
