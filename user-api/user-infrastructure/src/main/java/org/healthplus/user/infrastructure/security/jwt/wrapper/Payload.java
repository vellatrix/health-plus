package org.healthplus.user.infrastructure.security.jwt.wrapper;

import lombok.Getter;
import org.healthplus.user.domain.dto.TokenPayloadDto;

@Getter
public class Payload {

  private TokenPayloadDto payloadDto;

  private Payload(TokenPayloadDto payloadDto) {
    this.payloadDto = payloadDto;
  }

  public static Payload from(TokenPayloadDto payloadDto) {
    return new Payload(payloadDto);
  }

  public TokenPayloadDto currentPayload() {
    return payloadDto;
  }

}
