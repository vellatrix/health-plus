package org.healthplus.user.infrastructure.security.jwt.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Base64;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecoderTest {
  
  @Test
  public void decoderTest() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    Person person = new Person("lee", 20);
    String jsonUser = objectMapper.writeValueAsString(person);

    String encodedString = "eyJuYW1lIjoibGVlIiwiYWdlIjoyMH0=";
    byte[] decode = Base64.getDecoder().decode(encodedString);
    String decodedString = new String(decode);
    Assertions.assertThat(decodedString).isEqualTo(jsonUser);
  }

}
