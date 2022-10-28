package org.healthplus.deliveryworker.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 배달 목적지 Entity
* */
@Entity
@Table(name = "delivery")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "delivery_id")
  private Long deliveryId;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "driver_id")
  private Long driverId;

  @Column(name = "city")
  private String city;

  @Column(name = "street")
  private String street;

  @Column(name = "zip_code")
  @Nullable
  private String zipCode;

  @Builder
  public Delivery(Long deliveryId,
                  Long orderId,
                  Long driverId,
                  String city,
                  String street,
                  String zipCode) {
    this.deliveryId = deliveryId;
    this.orderId = orderId;
    this.driverId = driverId;
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
