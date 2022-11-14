package org.healthplus.user.domain.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenPayloadDto {

  private String id;
  private String name;
  private String email;
//  private LocalDateTime expired = null;


  /*public TokenPayloadDto toPayload(String id, String name, String email) {
    return new TokenPayloadDto(id, name, email);
  }*/
}
