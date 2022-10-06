package org.healthplus.deliveryworker.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.presentation.requestDto.DeliverySignUpInfoDto;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.healthplus.deliveryworker.service.impl.DeliveryDriverServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/delivery-driver")
@RequiredArgsConstructor
public class DeliveryDriverController {

  private final DeliveryDriverService deliveryDriverService;

  @GetMapping("/{driverId}")
  public String getDeliveryDriverInfo(@PathVariable Long driverId) {
    log.info("delivery driver id is {}", driverId);
    return "OK";
  }

  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping("/signup")
  public String signUp(@RequestBody DeliverySignUpInfoDto deliverySignUpInfoDto) {
    return deliveryDriverService.signUpCommand(deliverySignUpInfoDto.toServiceDto());
  }
}
