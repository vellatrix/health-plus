package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.OptionNotFoundException;
import org.healthplus.shop.domain.enums.IsYn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class OptionGroupDomain {

  private Long id;
  private MenuDomain menu;
  private List<OptionDomain> options = new ArrayList<>();
  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private IsYn useYn;

  @Builder
  public OptionGroupDomain(Long id, IsYn basicChoiceYn, IsYn etcChoiceYn, List<OptionDomain> options) {
    this.id = id;
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.options = options;
  }

  public OptionGroupDomain(IsYn basicChoiceYn, IsYn etcChoiceYn, List<OptionDomain> options) {
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.options = options;
  }

  public void addOption(OptionDomain option) {
    this.options.add(option);
    option.setOptionGroup(this);
  }

  public void setMenu(MenuDomain menu) {
    this.menu = menu;
  }

  public OptionDomain findOption(Long optionId) {
    return this.options.stream()
            .filter(o -> o.getId() == optionId)
            .findFirst()
            .orElseThrow(OptionNotFoundException::new);
  }

  public void deleteOption(Long optionId) {
    OptionDomain option = findOption(optionId);
    this.options.remove(option);
  }

  public void changeOptionGroup(OptionGroupDomain optionGroup) {
    this.basicChoiceYn = optionGroup.getBasicChoiceYn();
    this.etcChoiceYn = optionGroup.getEtcChoiceYn();

    this.options.forEach(innerOption -> {
      OptionDomain option = optionGroup.getOptions().stream()
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
    OptionGroupDomain that = (OptionGroupDomain) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
