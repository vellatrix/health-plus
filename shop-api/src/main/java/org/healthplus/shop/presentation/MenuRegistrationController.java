package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.MenuRegistrationService;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.presentation.convertor.MenuDtoConvertor;
import org.healthplus.shop.presentation.dto.request.MenuRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.MenuRegistrationResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class MenuRegistrationController {

  private final MenuRegistrationService menuRegistrationService;

  @PostMapping("/{shopId}/menus")
  public ApiResponse<MenuRegistrationResponse> registerMenu(@PathVariable Long shopId,
                                                            @RequestBody @Valid MenuRegistrationRequest dto) {

    Menu menu = MenuDtoConvertor.toMenuRegistrationRequest(dto);
    Menu savedMenu = menuRegistrationService.registerMenu(shopId, menu);
    MenuRegistrationResponse responseData = MenuDtoConvertor.toMenuRegistrationResponse(savedMenu);

    return ApiResponse.success(responseData);
  }

}
