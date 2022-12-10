package org.healthplus.account.infrastructure.jwt;

import org.healthplus.account.domain.vo.TokenPayloadVo;

/*
 * header, payload, signature class를 갖고 token을 만들어 return합니다.
 * */
public class TokenProvider {

  private Header header;
  private Payload payload;
  private Signature signature;

  private TokenProvider(TokenPayloadVo tokenPayloadVo) {
    this.header = Header.from("HS256", "JWT");
    this.payload = Payload.of(tokenPayloadVo);
    this.signature = new Signature();
  }

  public static TokenProvider from(TokenPayloadVo tokenPayloadVo) {
    return new TokenProvider(tokenPayloadVo);
  }

  public String generate() {
    StringBuilder sb = new StringBuilder();

    // header append
    sb.append(header.headerEncodingProcess());
    sb.append(".");
    // payload append
    sb.append(payload.payloadEncodingProcess());
    // signature processing
    String sig = this.signature.encryptedSignature(sb.toString(), header.currentAlgorithm());
    sb.append(".");
    // signature append
    sb.append(sig);

    return sb.toString();
  }
}
