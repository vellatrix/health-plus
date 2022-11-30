package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.service.VendorRegistrationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopRegistrationController {

  private final VendorRegistrationService vendorRegistrationService;
}
