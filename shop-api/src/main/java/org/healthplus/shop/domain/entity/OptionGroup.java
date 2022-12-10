package org.healthplus.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.healthplus.shop.domain.enums.IsYn;
import org.healthplus.shop.domain.exception.OptionNotFoundException;

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
  public OptionGroup(Long id, IsYn basicChoiceYn, IsYn etcChoiceYn, IsYn useYn, List<Option> options) {
    this.id = id;
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.useYn = useYn;
    this.options = options;
  }

  public OptionGroup(IsYn basicChoiceYn, IsYn etcChoiceYn, List<Option> options) {
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.options = options;
  }

  public void changeData(OptionGroup optionGroup) {
    this.basicChoiceYn = optionGroup.getBasicChoiceYn();
    this.etcChoiceYn = optionGroup.getEtcChoiceYn();
    this.useYn = optionGroup.getUseYn();

    optionGroup.getOptions().forEach(o -> {
      Option option = findOption(o.getId());
      option.changeData(o);
    });

  }

  private Option findOption(Long optionId) {
    return this.options.stream()
            .filter(o -> o.getId() == optionId)
            .findAny()
            .orElseThrow(OptionNotFoundException::new);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OptionGroup that = (OptionGroup) o;
    return Objects.equals(id, that.id) && basicChoiceYn == that.basicChoiceYn && etcChoiceYn == that.etcChoiceYn && useYn == that.useYn;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, basicChoiceYn, etcChoiceYn, useYn);
  }
}
