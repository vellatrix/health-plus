package org.healthplus.user.infrastructure.security.jwt.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.junit.jupiter.api.Test;

class EncoderTest {

  @Test
  public void encoderTest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Person person = new Person("lee", 20);
    String jsonUser = objectMapper.writeValueAsString(person); // return {"name":"lee","age":20}
    String compareString = Base64.getEncoder().encodeToString(jsonUser.getBytes(StandardCharsets.UTF_8)); // return eyJuYW1lIjoibGVlIiwiYWdlIjoyMH0=
    assertThat(Encoder.generate(jsonUser)).isEqualTo(compareString);
  }

  @Test
  public void decoderTest() throws Exception {
    String encodedString = "MjM0ZWZlc3NsOw==";
    byte[] decode = Base64.getDecoder().decode(encodedString);
    String decodedString = new String(decode);
    System.out.println(decodedString);
    assertThat(decodedString).isEqualTo("234efessl;");
  }
}
