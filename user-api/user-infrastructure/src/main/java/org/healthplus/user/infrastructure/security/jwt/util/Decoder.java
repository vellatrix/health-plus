package org.healthplus.user.infrastructure.security.jwt.util;

import java.util.Base64;

public class Decoder {

  /*
  * header.payload.signature -> string array -> {"header", "payload", "signature"}
  * */
  public static String generate(String token) {
    String[] split = token.split(".");
    String encodedPayload = split[1];
    return new String(Base64.getDecoder().decode(encodedPayload));
  }
}
