package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.entity.Bank;
import org.healthplus.shop.domain.entity.Vendor;
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

  public void changeVendorData(Vendor entity) {
    entity.setNickName(this.nickName);
    entity.setEmail(this.email);
  }

  public Vendor addVendor() {
    return Vendor.builder()
            .nickName(this.nickName)
            .name(this.name)
            .email(this.email)
            .phoneNumber(this.phoneNumber)
            .password(this.password)
            .userId(this.userId.getUserId())
            .build();
  }
}
