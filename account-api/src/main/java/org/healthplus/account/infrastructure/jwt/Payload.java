package org.healthplus.account.infrastructure.jwt;

import java.nio.charset.StandardCharsets;
import lombok.Getter;
import org.healthplus.account.domain.vo.TokenPayloadVo;
import org.healthplus.account.infrastructure.jwt.util.Encoder;
import org.healthplus.account.infrastructure.jwt.util.ObjectToJsonChanger;
import org.healthplus.model.role.Role;

@Getter
public class Payload {

  private Long userId;
  private String email;
  private Role role;

  private Payload() {
  }

  private Payload(Long userId, String email, Role role) {
    this.userId = userId;
    this.email = email;
    this.role = role;
  }

  public static Payload of(TokenPayloadVo tokenPayloadVo) {
    return new Payload(tokenPayloadVo.getUserId(),
        tokenPayloadVo.getEmail(),
        tokenPayloadVo.getRole());
  }

  public Payload currentPayload() {
    return this;
  }

  public String payloadEncodingProcess() {
    String jsonTypePayload = ObjectToJsonChanger.changer(this);
    return Encoder.run(jsonTypePayload.getBytes(StandardCharsets.UTF_8));
  }
}
