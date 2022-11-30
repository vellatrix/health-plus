package org.healthplus.shop.domain.shop;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.OptionNotFoundException;
import org.healthplus.shop.domain.shop.enums.IsYn;

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

  public void addOption(Option option) {
    this.options.add(option);
    option.setOptionGroup(this);
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Option findOption(Long optionId) {
    return this.options.stream()
            .filter(o -> o.getId() == optionId)
            .findFirst()
            .orElseThrow(OptionNotFoundException::new);
  }

  public void deleteOption(Long optionId) {
    Option option = findOption(optionId);
    this.options.remove(option);
  }

  public void changeOptionGroup(OptionGroup optionGroup) {
    this.basicChoiceYn = optionGroup.getBasicChoiceYn();
    this.etcChoiceYn = optionGroup.getEtcChoiceYn();

    this.options.forEach(innerOption -> {
      Option option = optionGroup.getOptions().stream()
              .filter(outerOption -> outerOption.getId() == innerOption.getId())
              .findAny()
              .orElseThrow(OptionNotFoundException::new);

      innerOption.changeOption(option);
    });
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OptionGroup that = (OptionGroup) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
