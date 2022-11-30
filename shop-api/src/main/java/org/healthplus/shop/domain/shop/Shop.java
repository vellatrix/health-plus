package org.healthplus.shop.domain.shop;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.domain.shop.enums.IsYn;
import org.healthplus.shop.domain.shop.enums.OpenStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shop")
@Getter
public class Shop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "shop_id")
  private Long id;

  @Embedded
  private Business business;

  private Integer minimumPrice;
  private Integer deliveryFee;

  @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Menu> menus = new ArrayList<>();

  private VendorId vendorId;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING)
  private OpenStatus openStatus;

  @Builder
  public Shop(Business business, Integer minimumPrice, Integer deliveryFee, VendorId vendorId, Address address) {
    this.business = business;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.vendorId = vendorId;
    this.address = address;
  }

  public Shop(Long shopId, String businessHour, Integer deliveryFee, Integer minimumPrice) {
    this.id = shopId;
    this.business.changeBusinessHour(businessHour);
    this.deliveryFee = deliveryFee;
    this.minimumPrice = minimumPrice;
  }

  public void closeShop() {
    this.openStatus = OpenStatus.CLOSED;
  }

  public void openShop() {
    this.openStatus = OpenStatus.OPEN;
  }

  public void addMenu(Menu menu) {
    this.menus.add(menu);
    menu.setShop(this);
  }

  public Menu findMenu(Long menuId) {
    return this.menus.stream()
            .filter(menu -> menu.getId() == menuId)
            .findFirst()
            .orElseThrow(MenuNotFoundException::new);
  }

  public void deleteMenu(Long menuId) {
    Menu menu = findMenu(menuId);
    this.menus.remove(menu);
  }

  public void changeShopData(Shop from) {
    this.business = from.business;
    this.minimumPrice = from.minimumPrice;
    this.deliveryFee = from.deliveryFee;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Shop shop = (Shop) o;
    return id.equals(shop.id) && business.equals(shop.business) && vendorId.equals(shop.vendorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, business, vendorId);
  }
}
