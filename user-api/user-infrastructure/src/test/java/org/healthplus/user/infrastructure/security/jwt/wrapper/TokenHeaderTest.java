package org.healthplus.user.infrastructure.security.jwt.wrapper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class TokenHeaderTest {

  @Test
  public void tokenHeaderValueTest() throws Exception {
    assertDoesNotThrow(() -> TokenHeader.of("HS256", "JWT"));
  }

}
