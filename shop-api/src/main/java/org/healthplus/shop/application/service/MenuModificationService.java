package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuModificationService {

  private final ShopRepository shopRepository;

  @Transactional
  public Menu modifyMenu(Menu menuData) {

    Menu menu = shopRepository.findMenuByMenuId(menuData.getId()).orElseThrow(MenuNotFoundException::new);

    menu.changeMenu(menuData);

    return menu;
  }
}
