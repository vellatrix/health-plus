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


  public void changeBusinessHour(String businessHour) {
    this.businessHour = businessHour;
  }
}
