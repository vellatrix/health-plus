package org.healthplus.shop.domain.shop;

import lombok.Getter;
import org.healthplus.shop.domain.shop.enums.IsYn;

import javax.persistence.Column;
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
  private Money price;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  public void setOptionGroup(OptionGroup optionGroup) {
    this.optionGroup = optionGroup;
  }

}
