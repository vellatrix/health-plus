package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.enums.ShopStatus;

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

  private Long vendorId;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING)
  private ShopStatus shopStatus;

  @Builder
  public Shop(Business business, Integer minimumPrice, Integer deliveryFee, Long vendorId, Address address) {
    this.business = business;
    this.minimumPrice = minimumPrice;
    this.deliveryFee = deliveryFee;
    this.vendorId = vendorId;
    this.address = address;
  }


}
