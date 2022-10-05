package org.healthplus.vendor.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import org.healthplus.vendor.enums.IsYn;

@Getter
public class RestaurantInfoInquiryDTO {

  private String businessName;
  private String businessHour;
  private String businessNumber;
  private Integer minimumPrice;
  private Integer deliveryFee;
  private IsYn openYn;
  private String city;
  private String street;
  private String zipCode;

  @QueryProjection
  public RestaurantInfoInquiryDTO(String businessName,
                                  String businessHour,
                                  String businessNumber,
                                  Integer minimumPrice,
                                  Integer deliveryFee,
                                  IsYn openYn,
                                  String city,
                                  String street,
                                  String zipCode) {
    this.businessName = businessName;
    this.businessHour = businessHour;
    this.businessNumber = businessNumber;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.openYn = openYn;
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
