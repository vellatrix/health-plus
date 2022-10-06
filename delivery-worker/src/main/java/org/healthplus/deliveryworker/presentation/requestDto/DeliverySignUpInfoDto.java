package org.healthplus.deliveryworker.presentation.requestDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;
import org.healthplus.deliveryworker.service.dto.requestDto.DeliveryDriverControllerToServiceDto;

@Getter
@Builder
@NoArgsConstructor
public class DeliverySignUpInfoDto {

  private String id;
  private String password;
  private String email;
  private String location;
  private DeliveryType deliveryType;
  private String vehicleNumber;
  private String phoneNumber;
  private String name;
  private IsYn userYn;

  public DeliverySignUpInfoDto(String id, String password, String email, String location,
      DeliveryType deliveryType, String vehicleNumber, String phoneNumber, String name, IsYn isYn) {
    this.id = id;
    this.password = password;
    this.email = email;
    this.location = location;
    this.deliveryType = deliveryType;
    this.vehicleNumber = vehicleNumber;
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.userYn = isYn;
  }

  public DeliveryDriverControllerToServiceDto toServiceDto() {
    return new DeliveryDriverControllerToServiceDto(
        this.id,
        this.password,
        this.email,
        this.location,
        this.deliveryType,
        this.vehicleNumber,
        this.phoneNumber,
        this.name,
        this.userYn
    );
  }

}
