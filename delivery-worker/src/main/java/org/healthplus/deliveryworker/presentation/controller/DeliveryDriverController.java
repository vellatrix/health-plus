package org.healthplus.deliveryworker.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.enums.Result;
import org.healthplus.deliveryworker.presentation.requestDto.DeliveryDriverRegistrationDTO;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverProfileDTO;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverRegistrationResultDTO;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-driver")
@Slf4j
@RequiredArgsConstructor
public class DeliveryDriverController {

  private final DeliveryDriverService deliveryDriverService;

  @PostMapping
  public ResponseEntity<DeliveryDriverRegistrationResultDTO> addDeliveryDriver(
      @RequestBody DeliveryDriverRegistrationDTO dto) {
    return ResponseEntity.ok(deliveryDriverService.registerDriver(dto.toCommand()));
  }

  @GetMapping("/{driverId}/profile")
  public ResponseEntity<DeliveryDriverProfileDTO> getDriverProfile(@PathVariable Long driverId) {
    return ResponseEntity.ok(deliveryDriverService.getDriverProfile(driverId));
  }

  @DeleteMapping("/{driverId}")
  public ResponseEntity<Result> removeDriverInfo(@PathVariable Long driverId) {
    return ResponseEntity.ok(deliveryDriverService.removeDriver(driverId));
  }
}
