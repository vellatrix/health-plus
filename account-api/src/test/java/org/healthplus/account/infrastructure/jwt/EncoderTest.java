package org.healthplus.account.infrastructure.jwt;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.healthplus.account.infrastructure.jwt.util.Encoder;
import org.junit.jupiter.api.Test;

class EncoderTest {

  @Test
  public void base64EncodingTest() throws Exception {
    assertThat(Encoder.run("abc".getBytes(StandardCharsets.UTF_8))).isEqualTo(
        Base64.getEncoder().withoutPadding().encodeToString("abc".getBytes(
            StandardCharsets.UTF_8)));
  }

}
