package org.healthplus.deliveryworker.presentation.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;

@Getter
@NoArgsConstructor
public class DeliveryDriverRegistrationDTO {

  private String id;
  private String password;
  private String email;
  private String location;
  private DeliveryType deliveryType;
  private String vehicleNumber;
  private String phoneNumber;
  private String name;
  private IsYn userYn;


  public DeliveryInfoCommand toCommand() {
    return new DeliveryInfoCommand(id, password, email, location, deliveryType, vehicleNumber,
        phoneNumber, name, userYn);
  }
}
