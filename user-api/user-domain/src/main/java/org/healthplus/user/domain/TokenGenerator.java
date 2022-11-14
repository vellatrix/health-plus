package org.healthplus.user.domain;

import org.healthplus.user.domain.dto.TokenPayloadDto;

public interface TokenGenerator {

    String generate(TokenPayloadDto tokenPayloadDto);

}
