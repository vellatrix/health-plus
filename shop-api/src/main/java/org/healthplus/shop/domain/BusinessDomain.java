package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BusinessDomain {

  private String businessName;
  private String businessNumber;
  private String businessHour;
  private String mainType;
  private String subType;

  public BusinessDomain(String businessHour) {
    this.businessHour = businessHour;
  }
}
