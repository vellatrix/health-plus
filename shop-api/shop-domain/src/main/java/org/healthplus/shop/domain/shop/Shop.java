package org.healthplus.shop.domain.shop;

import lombok.Getter;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.domain.shop.enums.IsYn;
import org.hibernate.annotations.SortNatural;

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
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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

  @SortNatural
  @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
  private SortedSet<Menu> menus = new TreeSet<>();

  private VendorId vendorId;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING)
  private IsYn openYn;

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


}
