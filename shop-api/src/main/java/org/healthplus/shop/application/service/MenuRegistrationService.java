package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.MenuDomain;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuRegistrationService {

  private final ShopRepository shopRepository;

  @Transactional
  public Menu registerMenu(Long shopId, MenuDomain menuDomain) {
    shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);
    Menu menu = menuDomain.addMenu(shopId);

    return shopRepository.saveMenu(menu);
  }
}
