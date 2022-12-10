package org.healthplus.account.infrastructure.jwt;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.healthplus.account.infrastructure.exception.JwtException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeaderTest {

  @DisplayName("header pass test")
  @Test
  public void headerInitConstructorTest() throws Exception {
    assertDoesNotThrow(() -> Header.from("HS256", "JWT"));
  }

  @DisplayName("header type exception test")
  @Test
  public void headerAlgorithmException() throws Exception {
    assertThatThrownBy(() -> Header.from("abcd", "JWT"))
        .isInstanceOf(JwtException.class);
  }

  @DisplayName("header type exception test")
  @Test
  public void headerTypeException() throws Exception {
    assertThatThrownBy(() -> Header.from("HS256", "abcd"))
        .isInstanceOf(JwtException.class);
  }
}
