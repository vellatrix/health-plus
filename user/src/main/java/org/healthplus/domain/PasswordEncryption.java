package org.healthplus.domain;

/*
 * password 암호화
 * */
public interface PasswordEncryption {

  String encryptor(String password);

  boolean matchPassword(String encryptedPassword, String plainText);
}
