package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.MenuRetrievalService;
import org.healthplus.shop.application.service.ShopRetrievalService;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.presentation.convertor.MenuDtoConvertor;
import org.healthplus.shop.presentation.dto.response.MenuRetrievalResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/shops")
public class MenuRetrievalController {

  private final ShopRetrievalService shopRetrievalService;
  private final MenuRetrievalService menuRetrievalService;

  @GetMapping("/{shopId}/menus/{menuId}")
  public ApiResponse<?> retrieveMenu(@PathVariable Long shopId,
                                     @PathVariable Long menuId) {

    shopRetrievalService.retrieveShop(shopId);
    Menu menu = menuRetrievalService.retrieveMenu(menuId);
    MenuRetrievalResponse responseData = MenuDtoConvertor.toMenuRetrievalResponse(menu);

    return ApiResponse.success(responseData);
  }

  @GetMapping("/{shopId}/menus")
  public ApiResponse<List<?>> retrieveMenus(@PathVariable Long shopId,
                                            int start,
                                            int size) {

    List<Menu> menus = menuRetrievalService.retrieveMenus(shopId, start, size);
    List<MenuRetrievalResponse> responseDataList = new ArrayList<>();
    menus.forEach(menu -> responseDataList.add(MenuDtoConvertor.toMenuRetrievalResponse(menu)));

    return ApiResponse.success(responseDataList);
  }

}
