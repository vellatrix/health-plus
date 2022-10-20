package org.healthplus.deliveryworker.presentation.responseDto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;

@Getter
@Builder
public class DeliveryDriverRegistrationResultDTO {

  private String id;
  private String password;
  private String email;
  private String location;
  private DeliveryType deliveryType;
  private String vehicleNumber;
  private String phoneNumber;
  private String name;
  private IsYn userYn;

  public static DeliveryDriverRegistrationResultDTO addDriverResult(
      DeliveryDriver deliveryDriver) {
    return DeliveryDriverRegistrationResultDTO.builder()
        .id(deliveryDriver.getId())
        .password(deliveryDriver.getPassword())
        .email(deliveryDriver.getEmail())
        .location(deliveryDriver.getLocation())
        .deliveryType(deliveryDriver.getDeliveryType())
        .vehicleNumber(deliveryDriver.getVehicleNumber())
        .phoneNumber(deliveryDriver.getPhoneNumber())
        .name(deliveryDriver.getName())
        .userYn(deliveryDriver.getUserYn())
        .build();
  }

}
