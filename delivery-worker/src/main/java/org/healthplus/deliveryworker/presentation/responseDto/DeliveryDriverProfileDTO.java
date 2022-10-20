package org.healthplus.deliveryworker.presentation.responseDto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.deliveryworker.entity.DeliveryDriver;

@Getter
@Builder
public class DeliveryDriverProfileDTO {

  private String id;
  private String name;
  private String email;
  private String phoneNumber;
  private String location;

  public static DeliveryDriverProfileDTO setProfile(DeliveryDriver deliveryDriver) {
    return DeliveryDriverProfileDTO.builder()
        .id(deliveryDriver.getId())
        .name(deliveryDriver.getName())
        .email(deliveryDriver.getEmail())
        .phoneNumber(deliveryDriver.getPhoneNumber())
        .location(deliveryDriver.getLocation()).build();
  }

}
