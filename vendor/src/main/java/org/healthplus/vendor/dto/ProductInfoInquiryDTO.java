package org.healthplus.vendor.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import org.healthplus.vendor.enums.IsYn;

@Getter
public class ProductInfoInquiryDTO {

  private String businessName;
  private String productName;
  private String description;
  private Integer calorie;
  private IsYn soldYn;
  private Integer price;
  private ProductOptionGroupInfoDTO optionGroup;

  @QueryProjection
  public ProductInfoInquiryDTO(String businessName,
                               String productName,
                               String description,
                               Integer calorie,
                               IsYn soldYn,
                               Integer price) {
    this.businessName = businessName;
    this.productName = productName;
    this.description = description;
    this.calorie = calorie;
    this.soldYn = soldYn;
    this.price = price;
  }

  public void addOptionGroup(ProductOptionGroupInfoDTO optionGroup) {
    this.optionGroup = optionGroup;
  }

}
