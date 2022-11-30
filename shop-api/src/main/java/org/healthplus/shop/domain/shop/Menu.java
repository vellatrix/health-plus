package org.healthplus.shop.domain.shop;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.OptionGroupNotFoundException;
import org.healthplus.shop.domain.shop.enums.IsYn;
import org.healthplus.shop.domain.shop.enums.Type;

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
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_id")
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Type type;

  @Embedded
  private Money price;

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
  public Menu(Long id, String name, Type type, Money price, String description, List<OptionGroup> optionGroups, Category category) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
    this.description = description;
    this.optionGroups = optionGroups;
    this.category = category;
  }

  @Builder
  public Menu(String name, Type type, Money price, String description, List<OptionGroup> optionGroups, Category category) {
    this.name = name;
    this.type = type;
    this.price = price;
    this.description = description;
    this.optionGroups = optionGroups;
    this.category = category;
  }

  public Menu() {

  }

  public void checkValidCategory() {
    if(this.category == null) throw new IllegalStateException("존재하지 않는 카테고리입니다.");
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public void addOptionGroup(OptionGroup optionGroup) {
    this.optionGroups.add(optionGroup);
    optionGroup.setMenu(this);
  }

  public OptionGroup findOptionGroup(Long optionGroupId) {
    return this.optionGroups.stream()
            .filter(og -> og.getId() == optionGroupId)
            .findFirst()
            .orElseThrow(OptionGroupNotFoundException::new);
  }

  public void changeMenu(Menu menu) {
    this.name = menu.getName();
    this.type = menu.getType();
    this.price = menu.getPrice();
    this.description = menu.getDescription();

    this.optionGroups.forEach(innerOptionGroup -> {
      OptionGroup optionGroup = menu.getOptionGroups().stream()
              .filter(outerOptionGroup -> innerOptionGroup.getId() == outerOptionGroup.getId())
              .findAny()
              .orElseThrow(OptionGroupNotFoundException::new);

      innerOptionGroup.changeOptionGroup(optionGroup);
    });

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
