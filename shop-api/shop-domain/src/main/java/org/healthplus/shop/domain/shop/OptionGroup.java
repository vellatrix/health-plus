package org.healthplus.shop.domain.shop;

import lombok.Getter;
import org.healthplus.shop.domain.exception.OptionNotFoundException;
import org.healthplus.shop.domain.shop.enums.IsYn;
import org.hibernate.annotations.SortNatural;

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
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

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

  @SortNatural
  @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
  private SortedSet<Option> options = new TreeSet<>();

  @Enumerated(EnumType.STRING)
  private IsYn basicChoiceYn;

  @Enumerated(EnumType.STRING)
  private IsYn etcChoiceYn;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

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
    options.remove(option);
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
