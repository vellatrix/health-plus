package org.healthplus.deliveryworker.service.command;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;

@AllArgsConstructor
@Getter
@ToString
public class DeliveryDriverInfoCommand {

  private String id;
  private String password;
  private String email;
  private String location;
  private DeliveryType deliveryType;
  private String vehicleNumber;
  private String phoneNumber;
  private String name;
  private IsYn userYn;
  

  public DeliveryDriver toEntity() {
    return DeliveryDriver.registrationBuilder()
        .id(id)
        .name(name)
        .password(password)
        .email(email)
        .location(location)
        .phoneNumber(phoneNumber)
        .vehicleNumber(vehicleNumber)
        .deliveryType(deliveryType)
        .createdAt(LocalDateTime.now())
        .userYn(userYn)
        .build();
  }
}
