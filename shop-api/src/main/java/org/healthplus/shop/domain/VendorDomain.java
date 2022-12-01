package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.entity.Bank;
import org.healthplus.shop.domain.enums.IsYn;
import java.time.LocalDateTime;

@Getter
public class VendorDomain {

  private Long id;
  private String nickName;
  private String email;
  private String phoneNumber;
  private String name;
  private String password;

  private Bank bank;
  private UserIdDomain userId;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private LocalDateTime deletedAt;
  private IsYn useYn;

  @Builder
  public VendorDomain(String nickName,
                String email,
                String phoneNumber,
                String name,
                String password,
                UserIdDomain userId) {
    this.nickName = nickName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.password = password;
    this.userId = userId;
  }

  public VendorDomain(Long id, String nickName, String email) {
    this.id = id;
    this.nickName = nickName;
    this.email = email;
  }

  public void changeVendorData(VendorDomain from) {
    this.nickName = from.nickName;
    this.email = from.email;
  }
}
