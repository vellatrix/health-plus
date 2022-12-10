package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Business {

  private String businessName;
  private String businessNumber;
  private String businessHour;
  private String mainType;
  private String subType;

  public void setBusinessHour(String businessHour) {
    this.businessHour = businessHour;
  }

  @Builder
  public Business(String businessName, String businessNumber, String businessHour, String mainType, String subType) {
    this.businessName = businessName;
    this.businessNumber = businessNumber;
    this.businessHour = businessHour;
    this.mainType = mainType;
    this.subType = subType;
  }

  public Business(String businessHour) {
    this.businessHour = businessHour;
  }
}
