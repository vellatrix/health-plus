package org.healthplus.user.infrastructure.security.jwt;

import org.healthplus.user.domain.dto.TokenPayloadDto;
import org.junit.jupiter.api.Test;

class TokenTest {

  @Test
  public void dataEncodingTokenTest() throws Exception {
    TokenPayloadDto payloadDto = TokenPayloadDto.builder()
        .id("yeon")
        .name("lee")
        .email("@gamil.com").build();

    TokenProvider token = TokenProvider.of(payloadDto);
    String generate = token.generate();
    System.out.println(generate);
  }

}
