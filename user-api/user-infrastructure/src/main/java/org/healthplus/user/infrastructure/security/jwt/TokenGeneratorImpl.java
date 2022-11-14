package org.healthplus.user.infrastructure.security.jwt;

import org.healthplus.user.domain.TokenGenerator;
import org.healthplus.user.domain.dto.TokenPayloadDto;
import org.springframework.stereotype.Component;

@Component
public class TokenGeneratorImpl implements TokenGenerator {
  @Override
  public String generate(TokenPayloadDto payloadDto){
    return TokenProvider.of(payloadDto).generate();
  }
}
