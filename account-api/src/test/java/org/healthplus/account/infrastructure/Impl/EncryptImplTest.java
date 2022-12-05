package org.healthplus.account.infrastructure.Impl;

import org.assertj.core.api.Assertions;
import org.healthplus.account.domain.EncryptMapper;
import org.healthplus.account.infrastructure.EncryptMapperStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EncryptImplTest {

  private EncryptMapper encryptMapper;

  @BeforeEach
  void setUp() {
    encryptMapper = new EncryptMapperStub();
  }

  @DisplayName("암호화 정상 동작 테스트")
  @Test
  public void bcryptSimpleTest() throws Exception {
    String password = "HealthPlusProject1!";
    String encrypted = encryptMapper.encoder(password);
    Assertions.assertThat(encryptMapper.isMatch(password, encrypted));
  }

}
