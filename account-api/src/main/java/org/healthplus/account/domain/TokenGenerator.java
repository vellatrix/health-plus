package org.healthplus.account.domain;

import org.healthplus.account.domain.vo.TokenPayloadVo;

public interface TokenGenerator {

  String generateAccessToken(TokenPayloadVo tokenPayloadVo);

}
