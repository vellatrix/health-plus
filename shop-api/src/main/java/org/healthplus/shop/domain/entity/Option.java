package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.healthplus.shop.domain.enums.IsYn;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "options")
@Getter
public class Option {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "option_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "option_group_id")
  private OptionGroup optionGroup;

  private String name;
  private Integer price;
  private Integer displayOrder;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  @Builder
  public Option(Long id, String name, Integer price, Integer displayOrder, IsYn useYn) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
    this.useYn = useYn;
  }

  public Option(String name, Integer price, Integer displayOrder) {
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
  }


  public void changeData(Option option) {
    this.name = option.getName();
    this.price = option.getPrice();
    this.displayOrder = option.getDisplayOrder();
    this.useYn = option.getUseYn();
  }
}
