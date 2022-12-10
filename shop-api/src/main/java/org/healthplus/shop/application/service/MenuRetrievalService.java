package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuRetrievalService {

  private final ShopRepository shopRepository;

  public Menu retrieveMenu(Long menuId) {
    return shopRepository.findMenuByMenuId(menuId).orElseThrow(MenuNotFoundException::new);
  }

  public List<Menu> retrieveMenus(Long shopId, int start, int size) {
    return shopRepository.findMenus(shopId, start, size);
  }
}
