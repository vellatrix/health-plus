package org.healthplus.deliveryworker.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.deliveryworker.enums.DeliveryStatus;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/*
 * 배달 노동자 Entity
 * */
@Entity
@Table(name = "delivery_driver")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryDriver {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "driver_id")
  private Long driverId;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn userYn;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "vehicle_number")
  private String vehicleNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "delivery_type")
  private DeliveryType deliveryType;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @Column(name = "id")
  private String id;

  @Column(name = "password")
  private String password;
  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String name;

  @Column(name = "location")
  private String location;

  @Enumerated(EnumType.STRING)
  @Column(name = "delivery_status")
  private DeliveryStatus deliveryStatus;

  @Builder(builderMethodName = "registrationBuilder")
  public DeliveryDriver(
      IsYn userYn,
      String phoneNumber,
      String vehicleNumber,
      DeliveryType deliveryType,
      LocalDateTime createdAt,
      String id,
      String password,
      String email,
      String name,
      String location) {
    this.userYn = userYn;
    this.phoneNumber = phoneNumber;
    this.vehicleNumber = vehicleNumber;
    this.deliveryType = deliveryType;
    this.createdAt = LocalDateTime.now();
    this.id = id;
    this.password = password;
    this.email = email;
    this.name = name;
    this.location = location;
  }

}
