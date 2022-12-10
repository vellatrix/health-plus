package org.healthplus.account.infrastructure.jwt;

import org.healthplus.account.domain.TokenGenerator;
import org.healthplus.account.domain.vo.TokenPayloadVo;
import org.springframework.stereotype.Component;

// @Component
public class TokenGeneratorImpl implements TokenGenerator {

  @Override
  public String generateAccessToken(TokenPayloadVo tokenPayloadVo) {
    return TokenProvider.from(tokenPayloadVo).generate();
  }
}
