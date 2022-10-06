package org.healthplus.deliveryworker.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

  @GetMapping("/{deliveryId}")
  public String getDeliveryInfo(@PathVariable Long deliveryId) {
    log.info("delivery stuff is = {}", deliveryId);
    return "OK";
  }
}
