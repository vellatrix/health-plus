package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.MenuModificationService;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.presentation.convertor.MenuDtoConvertor;
import org.healthplus.shop.presentation.dto.request.MenuModificationRequest;
import org.healthplus.shop.presentation.dto.response.MenuModificationResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class MenuModificationController {

  private final MenuModificationService menuModificationService;

  @PatchMapping("/{shopId}/menus/{menuId}")
  public ApiResponse<MenuModificationResponse> modifyMenu(@PathVariable Long shopId,
                                                          @PathVariable Long menuId,
                                                          @RequestBody @Valid MenuModificationRequest dto) {

    Menu menu = MenuDtoConvertor.toMenuModificationRequest(dto);
    Menu modifiedMenu = menuModificationService.modifyMenu(menu);
    MenuModificationResponse responseData = MenuDtoConvertor.toMenuModificationResponse(modifiedMenu);

    return ApiResponse.success(responseData);
  }
}
