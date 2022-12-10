package org.healthplus.account.infrastructure.jwt;

import org.assertj.core.api.Assertions;
import org.healthplus.account.infrastructure.jwt.util.Decoder;
import org.junit.jupiter.api.Test;

class DecoderTest {

  @Test
  public void decoderTest() throws Exception {
    Assertions.assertThat(Decoder.run("YWJj")).isEqualTo("abc");
  }

}
