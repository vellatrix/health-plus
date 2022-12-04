package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@Setter
public class Business {

  private String businessName;
  private String businessNumber;
  private String businessHour;
  private String mainType;
  private String subType;


}
