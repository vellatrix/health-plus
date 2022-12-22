package org.healthplus.delivery.domain.entity;

import javax.persistence.Embeddable;
import lombok.Getter;
import org.healthplus.delivery.domain.enums.VehicleType;
import org.healthplus.delivery.domain.exception.VehicleTypeMisMatchException;

@Embeddable
@Getter
public class Vehicle {


  private String CarNumber;
  private VehicleType vehicleType;

  protected Vehicle() {
  }

  private Vehicle(String carNumber, String vehicleType) {
    CarNumber = carNumber;
    VehicleType type = canVehicleType(vehicleType);
    if (canVehicleType(vehicleType) == null) {
      throw new VehicleTypeMisMatchException("사용할 수 없는 차량 종류입니다.");
    }
    this.vehicleType = type;
  }


  public static Vehicle initVehicleInfo(String carNumber, String vehicleType) {
    return new Vehicle(carNumber, vehicleType);
  }

  private VehicleType canVehicleType(String vehicleType) {
    for (VehicleType type : VehicleType.values()) {
      if (type.name().equals(vehicleType)) {
        return type;
      }
    }
    return null;
  }
}
