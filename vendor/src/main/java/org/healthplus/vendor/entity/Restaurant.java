package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.healthplus.model.entity.Address;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "restaurant")
public class Restaurant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "restaurant_id")
  private Long restaurantId;

  @Column(name = "vendor_id")
  private Long vendorId;

  @Column(name = "business_name")
  private String businessName;

  @Column(name = "business_number")
  private String businessNumber;

  @Column(name = "business_hour")
  private String businessHour;

  @Column(name = "main_type")
  private String mainType;

  @Column(name = "sub_type")
  private String subType;

  @Column(name = "minimum_price")
  private Integer minimumPrice;

  @Column(name = "delivery_fee")
  private Integer deliveryFee;

  @Enumerated(EnumType.STRING)
  @Column(name = "open_yn")
  private IsYn openYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  @Embedded
  private Address address;

  public Restaurant() {
  }

  @Builder
  public Restaurant(Long restaurantId,
                    Long vendorId,
                    String businessName,
                    String businessNumber,
                    String businessHour,
                    String mainType,
                    String subType,
                    Integer minimumPrice,
                    Integer deliveryFee,
                    Address address) {
    this.restaurantId = restaurantId;
    this.vendorId = vendorId;
    this.businessName = businessName;
    this.businessNumber = businessNumber;
    this.businessHour = businessHour;
    this.mainType = mainType;
    this.subType = subType;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.openYn = IsYn.N;
    this.useYn = IsYn.Y;
    this.address = address;
  }
}
