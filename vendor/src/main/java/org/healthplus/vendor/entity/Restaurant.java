package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "restaurant")
@NoArgsConstructor
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

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "city")
  private String city;

  @Column(name = "street")
  private String street;

  @Column(name = "zip_code")
  @Nullable
  private String zipCode;


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
                    String city,
                    String street,
                    String zipCode) {
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
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
