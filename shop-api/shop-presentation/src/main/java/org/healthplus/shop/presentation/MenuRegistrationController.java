package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.MenuRegistrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class MenuRegistrationController {

  private final MenuRegistrationService menuRegistrationService;

}
