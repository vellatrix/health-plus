package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.entity.Address;
import org.healthplus.shop.domain.entity.Business;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.entity.ShopCategory;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.domain.enums.ShopStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class ShopDomain {

  private Long id;
  private ShopCategoryDomain categoryDomain;
  private BusinessDomain business;
  private Integer minimumPrice;
  private Integer deliveryFee;
  private List<MenuDomain> menus = new ArrayList<>();
  private VendorIdDomain vendorId;
  private AddressDomain address;
  private ShopStatus shopStatus;

  @Builder
  public ShopDomain(ShopCategoryDomain categoryDomain, BusinessDomain business, Integer minimumPrice, Integer deliveryFee, VendorIdDomain vendorId, AddressDomain address) {
    this.categoryDomain = categoryDomain;
    this.business = business;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.vendorId = vendorId;
    this.address = address;
  }

  public void closeShop() {
    this.shopStatus = shopStatus.CLOSED;
  }

  public void openShop() {
    this.shopStatus = shopStatus.OPEN;
  }

  public void addMenu(MenuDomain menu) {
    // Entity 연관관계 처리
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

  public void changeShopData(Shop shop) {
    shop.getBusiness().setBusinessNumber(business.getBusinessNumber());
    shop.setMinimumPrice(minimumPrice);
    shop.setDeliveryFee(deliveryFee);
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

  public Shop addShop() {
    return Shop.builder()
            .category(new ShopCategory(categoryDomain.getId()))
            .minimumPrice(minimumPrice)
            .deliveryFee(deliveryFee)
            .vendorId(vendorId.getVendorId())
            .business(Business.builder()
                    .businessName(business.getBusinessName())
                    .businessHour(business.getBusinessHour())
                    .businessNumber(business.getBusinessNumber())
                    .mainType(business.getMainType())
                    .subType(business.getSubType())
                    .build())
            .address(new Address(address.getCity(), address.getStreet(), address.getZipCode()))
            .build();
  }
}
