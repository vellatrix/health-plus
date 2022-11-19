package org.healthplus.shop.domain.vendor;

import lombok.Getter;
import org.healthplus.shop.domain.shop.Shop;
import org.healthplus.shop.domain.shop.enums.IsYn;

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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vendor")
@Getter
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vendor_id")
  private Long id;

  private transient List<Shop> shops = new ArrayList<>();

  @Embedded
  private UserId userId;

  @Column(name = "nick")
  private String nickName;

  private String email;

  private String phoneNumber;

  private String name;

  @Embedded
  private Bank bank;

  private String password;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

}
