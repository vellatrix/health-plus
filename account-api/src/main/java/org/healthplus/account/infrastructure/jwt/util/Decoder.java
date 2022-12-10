package org.healthplus.account.infrastructure.jwt.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decoder {

  public static String run(String givenEncodedString) {
    return new String(Base64.getDecoder().decode(givenEncodedString));
  }

}
