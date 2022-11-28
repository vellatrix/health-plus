package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.MenuModificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuModificationController {

  private final MenuModificationService menuModificationService;
}
