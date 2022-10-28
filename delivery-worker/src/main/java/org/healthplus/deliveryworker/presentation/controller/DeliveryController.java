package org.healthplus.deliveryworker.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.presentation.requestDto.DeliveryRegistrationDTO;
import org.healthplus.deliveryworker.service.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
@Slf4j
public class DeliveryController {

  private final DeliveryService deliveryService;

  @GetMapping
  public void getDeliveryInfo(@RequestBody DeliveryRegistrationDTO dto) {
    deliveryService.getDeliveryInfo(dto.toCommand());
  }
}
