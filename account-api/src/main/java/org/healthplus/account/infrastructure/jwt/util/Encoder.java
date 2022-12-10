package org.healthplus.account.infrastructure.jwt.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoder {

  public static String run(byte[] unEncodedString) {
    return Base64.getUrlEncoder().withoutPadding()
        .encodeToString(unEncodedString);
  }

}
