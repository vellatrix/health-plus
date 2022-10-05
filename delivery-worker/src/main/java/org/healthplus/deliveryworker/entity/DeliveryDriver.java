package org.healthplus.deliveryworker.entity;

import lombok.*;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;
import org.healthplus.model.entity.CommonDateTime;

import javax.persistence.*;
import java.time.LocalDateTime;

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

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @Embedded
  private CommonDateTime commonDateTime;

  private String id;
  private String password;
  private String email;
  private String name;
  private String location;


  @Builder
  public DeliveryDriver(Long driverId,
      IsYn userYn,
      String phoneNumber,
      String vehicleNumber,
      DeliveryType deliveryType,
      LocalDateTime deletedAt,
      CommonDateTime commonDateTime,
      String id,
      String password,
      String email,
      String name,
      String location) {
    this.driverId = driverId;
    this.userYn = userYn;
    this.phoneNumber = phoneNumber;
    this.vehicleNumber = vehicleNumber;
    this.deliveryType = deliveryType;
    this.deletedAt = deletedAt;
    this.commonDateTime = commonDateTime;
    this.id = id;
    this.password = password;
    this.email = email;
    this.name = name;
    this.location = location;
  }

}
