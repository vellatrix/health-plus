package org.healthplus.account.infrastructure.jwt;

import static org.healthplus.account.infrastructure.exception.ErrorCode.TOKEN_HEADER_TYPE_EXCEPTION;
import static org.healthplus.account.infrastructure.exception.ErrorCode.TOKEN_SIGNATURE_ALGORITHM_EXCEPTION;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.infrastructure.enums.HeaderType;
import org.healthplus.account.infrastructure.enums.SignatureAlgorithm;
import org.healthplus.account.infrastructure.exception.JwtException;
import org.healthplus.account.infrastructure.jwt.util.Encoder;
import org.healthplus.account.infrastructure.jwt.util.ObjectToJsonChanger;

@Getter
@Slf4j
public class Header {

  private SignatureAlgorithm alg;
  private HeaderType typ;

  private Header(String algo, String type) {

    isAlgorithm(algo);
    isHeader(type);

    this.alg = SignatureAlgorithm.valueOf(algo);
    this.typ = HeaderType.valueOf(type);
  }

  private void isHeader(String type) {
    List<String> checkList = new ArrayList<>();
    for (HeaderType header : HeaderType.values()) {
      checkList.add(header.name());
    }
    if (!checkList.contains(type)) {
      throw new JwtException(TOKEN_HEADER_TYPE_EXCEPTION);
    }
  }

  private void isAlgorithm(String algo) {
    List<String> checkList = new ArrayList<>();
    for (SignatureAlgorithm signatureAlgorithm : SignatureAlgorithm.values()) {
      checkList.add(signatureAlgorithm.name());
    }
    if (!checkList.contains(algo)) {
      throw new JwtException(TOKEN_SIGNATURE_ALGORITHM_EXCEPTION);
    }
  }

  public static Header from(String algo, String type) {
    return new Header(algo, type);
  }

  public String currentAlgorithm() {
    if (alg.name().equals("HS256")) {
      return "HmacSHA256";
    }
    if (alg.name().equals("RS256")) {
      return "RS256";
    }
    return "HmacSHA256";
  }

  public Header currentHeader() {
    return this;
  }

  public String headerEncodingProcess() {
    String jsonTypeHeader = ObjectToJsonChanger.changer(this);
    return Encoder.run(jsonTypeHeader.getBytes(StandardCharsets.UTF_8));
  }
}
