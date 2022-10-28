package org.healthplus.deliveryworker.presentation.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;

@Getter
@NoArgsConstructor
public class DeliveryRegistrationDTO {

  private Long orderId;
  private Long driverId;
  private String city;
  private String street;
  private String zipCode;

  public DeliveryInfoCommand toCommand() {
    return new DeliveryInfoCommand(orderId, driverId, city, street, zipCode);
  }
}
