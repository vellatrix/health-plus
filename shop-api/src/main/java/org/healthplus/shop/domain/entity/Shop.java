package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.healthplus.shop.domain.enums.ShopStatus;
import org.healthplus.shop.domain.exception.MenuNotFoundException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
@Getter
@NoArgsConstructor
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

  @JoinColumn(name = "cate_id")
  @OneToOne(fetch = FetchType.LAZY)
  private ShopCategory category;

  private Long vendorId;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING)
  private ShopStatus shopStatus;

  @Builder
  public Shop(ShopCategory category, Business business, Integer minimumPrice, Integer deliveryFee, Long vendorId, Address address) {
    this.category = category;
    this.business = business;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.vendorId = vendorId;
    this.address = address;
  }

  public void addMenu(Menu menu) {
    this.menus.add(menu);
    menu.setShop(this);
  }

  public Menu findMenu(Long menuId) {
    return this.menus.stream()
            .filter(menu -> menu.getId() == menuId)
            .findAny()
            .orElseThrow(MenuNotFoundException::new);
  }

  public void deleteMenu(Long menuId) {
    Menu menu = findMenu(menuId);
    this.menus.remove(menu);
  }

  public void changeData(Shop shopData) {
    this.business.setBusinessHour(shopData.getBusiness().getBusinessHour());
    this.minimumPrice = shopData.getMinimumPrice();
    this.deliveryFee = shopData.getDeliveryFee();
  }
}
