package org.healthplus.shop.entity;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.OptionNotFoundException;
import org.healthplus.shop.entity.enums.IsYn;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "option_group")
@Getter
public class OptionGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "option_group_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "menu_id")
  private Menu menu;

  @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Option> options = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private IsYn basicChoiceYn;

  @Enumerated(EnumType.STRING)
  private IsYn etcChoiceYn;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  @Builder
  public OptionGroup(Long id, IsYn basicChoiceYn, IsYn etcChoiceYn, List<Option> options) {
    this.id = id;
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.options = options;
  }

  public OptionGroup(IsYn basicChoiceYn, IsYn etcChoiceYn, List<Option> options) {
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.options = options;
  }


}
