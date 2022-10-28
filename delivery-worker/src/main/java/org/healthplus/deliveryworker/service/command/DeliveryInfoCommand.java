package org.healthplus.deliveryworker.service.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class DeliveryInfoCommand {

  private Long orderId;
  private Long driverId;
  private String city;
  private String street;
  private String zipCode;

}
