package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.domain.enums.ShopStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class ShopDomain {

  private Long id;
  private BusinessDomain business;
  private Integer minimumPrice;
  private Integer deliveryFee;
  private List<MenuDomain> menus = new ArrayList<>();
  private VendorIdDomain vendorId;
  private AddressDomain address;
  private ShopStatus shopStatus;

  @Builder
  public ShopDomain(BusinessDomain business, Integer minimumPrice, Integer deliveryFee, VendorIdDomain vendorId, AddressDomain address) {
    this.business = business;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.vendorId = vendorId;
    this.address = address;
  }

  public ShopDomain(Long shopId, String businessHour, Integer deliveryFee, Integer minimumPrice) {
    this.id = shopId;
    this.business.changeBusinessHour(businessHour);
    this.deliveryFee = deliveryFee;
    this.minimumPrice = minimumPrice;
  }

  public void closeShop() {
    this.shopStatus = shopStatus.CLOSED;
  }

  public void openShop() {
    this.shopStatus = shopStatus.OPEN;
  }

  public void addMenu(MenuDomain menu) {
    this.menus.add(menu);
    menu.setShop(this);
  }

  public MenuDomain findMenu(Long menuId) {
    return this.menus.stream()
            .filter(menu -> menu.getId() == menuId)
            .findFirst()
            .orElseThrow(MenuNotFoundException::new);
  }

  public void deleteMenu(Long menuId) {
    MenuDomain menu = findMenu(menuId);
    this.menus.remove(menu);
  }

  public void changeShopData(ShopDomain from) {
    this.business = from.business;
    this.minimumPrice = from.minimumPrice;
    this.deliveryFee = from.deliveryFee;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ShopDomain shop = (ShopDomain) o;
    return id.equals(shop.id) && business.equals(shop.business) && vendorId.equals(shop.vendorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, business, vendorId);
  }
}
