package org.healthplus.user.infrastructure.security.jwt;

import static org.healthplus.user.infrastructure.exception.ErrorCode.Encode_Exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.healthplus.user.domain.dto.TokenPayloadDto;
import org.healthplus.user.infrastructure.exception.JwtException;
import org.healthplus.user.infrastructure.security.jwt.util.Decoder;
import org.healthplus.user.infrastructure.security.jwt.util.Encoder;
import org.healthplus.user.infrastructure.security.jwt.wrapper.Payload;
import org.healthplus.user.infrastructure.security.jwt.wrapper.TokenHeader;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TokenProvider {

  private TokenHeader header;
  private Payload payload;
  private final String ServerSecreteKey = "HealthPlusProjectTokenKey";
  private ObjectMapper objectMapper = new ObjectMapper();

  private TokenProvider(String algo, String type, TokenPayloadDto payloadDto) {
    this.header = TokenHeader.of(algo, type);
    this.payload = Payload.from(payloadDto);
  }

  /*
   * 기존 Setting은 "HS256", "JWT" 입니다.
   * */
  public static TokenProvider of(TokenPayloadDto payloadDto) {
    return new TokenProvider("HS256", "JWT", payloadDto);
  }

  /*
   * Encoding method
   * */
  public String generate() {
    try {
      // header obj to json, payload obj to json
      String headerJson = objectMapper.writeValueAsString(header.currentTokenHeader());
      String payloadJson = objectMapper.writeValueAsString(payload.currentPayload());

      // encoding(headerJson) + . + encoding(payloadJson)
      String data = Encoder.generate(headerJson) + "." + Encoder.generate(payloadJson);

      // get signature
      String signature = makingSignature(data);
      return data + "." + signature;

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  /*
   * Decoding method
   * */
  public TokenPayloadDto degenerate(String token) {
    try {
      String encodedPayload = Decoder.generate(token);
      return objectMapper.readValue(encodedPayload, TokenPayloadDto.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }


  /*
  * HS256 변환
  * */
  private String makingSignature(String data) {
    try {
      // HS256 algorithm works in here
      byte[] hash = ServerSecreteKey.getBytes(StandardCharsets.UTF_8);
      Mac sha256Hmac = Mac.getInstance("HmacSHA256");
      SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
      sha256Hmac.init(secretKey);

      return Encoder.generate(String.valueOf(sha256Hmac.doFinal(
          data.getBytes(StandardCharsets.UTF_8))));
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new JwtException(Encode_Exception);
    }
  }

}
