package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.MenuRemovalService;
import org.healthplus.shop.application.service.ShopRetrievalService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class MenuRemovalController {

  private final MenuRemovalService menuRemovalService;

  @DeleteMapping("/{shopId}/menus/{menuId}")
  public ApiResponse<String> removeMenu(@PathVariable Long shopId,
                                        @PathVariable Long menuId) {
    menuRemovalService.removeMenu(shopId, menuId);

    return ApiResponse.success("success");
  }

}
