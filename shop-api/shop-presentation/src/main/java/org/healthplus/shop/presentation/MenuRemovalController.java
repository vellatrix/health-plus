package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.MenuInquiryService;
import org.healthplus.shop.application.MenuRemovalService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuRemovalController {

  private final MenuRemovalService menuRemovalService;
}
