package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.VendorModificationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VendorModificationController {

  private final VendorModificationService vendorModificationService;
}
