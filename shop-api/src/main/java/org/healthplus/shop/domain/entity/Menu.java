package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.shop.domain.enums.IsYn;
import org.healthplus.shop.domain.enums.Type;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "menu")
@Getter
@NoArgsConstructor
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_id")
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Type type;

  @Embedded
  private Money money;

  @Column(name = "desc")
  private String description;

  @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OptionGroup> optionGroups = new ArrayList<>();

  @JoinColumn(name = "shop_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Shop shop;

  @JoinColumn(name = "cate_id")
  @OneToOne(fetch = FetchType.LAZY)
  private Category category;

  @Enumerated(EnumType.STRING)
  private IsYn soldYn;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  @Builder
  public Menu(Long id, String name, Type type, Money money, String description, List<OptionGroup> optionGroups, Category category) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.money = money;
    this.description = description;
    this.optionGroups = optionGroups;
    this.category = category;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public void changeMenu(Menu menuData) {
    this.name = menuData.getName();
    this.type = menuData.getType();
    this.money = menuData.getMoney();
    this.description = menuData.getDescription();

    menuData.getOptionGroups().forEach(og -> {
      OptionGroup optionGroup = findOptionGroup(og.getId());
      optionGroup.changeData(og);
    });
  }

  public OptionGroup findOptionGroup(Long optionGroupId) {
    return this.optionGroups.stream()
            .filter(og -> og.getId() == optionGroupId)
            .findAny()
            .orElseThrow(MenuNotFoundException::new);
  }

  public void deleteOptionGroup(Long optionGroupId) {
    OptionGroup optionGroup = findOptionGroup(optionGroupId);
    this.optionGroups.remove(optionGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Menu menu = (Menu) o;
    return Objects.equals(id, menu.id) && Objects.equals(name, menu.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
