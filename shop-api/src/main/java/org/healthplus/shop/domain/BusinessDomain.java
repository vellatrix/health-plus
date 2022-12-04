package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BusinessDomain {

  private String businessName;
  private String businessNumber;
  private String businessHour;
  private String mainType;
  private String subType;

  @Builder
  public BusinessDomain(String businessName,
                        String businessNumber,
                        String businessHour,
                        String mainType,
                        String subType) {
    this.businessName = businessName;
    this.businessNumber = businessNumber;
    this.businessHour = businessHour;
    this.mainType = mainType;
    this.subType = subType;
  }

  public BusinessDomain(String businessHour) {
    this.businessHour = businessHour;
  }
}
