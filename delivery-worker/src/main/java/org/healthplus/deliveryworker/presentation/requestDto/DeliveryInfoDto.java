package org.healthplus.deliveryworker.presentation.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;

@Getter
@NoArgsConstructor
@Builder
@ToString
public class DeliveryInfoDto {

  private String id;
  private String password;
  private String email;
  private String location;
  private DeliveryType deliveryType;
  private String vehicleNumber;
  private String phoneNumber;
  private String name;
  private IsYn userYn;

  public DeliveryInfoDto(String id, String password, String email, String location,
      DeliveryType deliveryType, String vehicleNumber, String phoneNumber, String name,
      IsYn userYn) {
    this.id = id;
    this.password = password;
    this.email = email;
    this.location = location;
    this.deliveryType = deliveryType;
    this.vehicleNumber = vehicleNumber;
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.userYn = userYn;
  }

  public DeliveryInfoCommand toCommand() {
    return new DeliveryInfoCommand(id, password, email, location, deliveryType, vehicleNumber,
        phoneNumber, name, userYn);
  }
}
