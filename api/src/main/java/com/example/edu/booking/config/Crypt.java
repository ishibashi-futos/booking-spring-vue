package com.example.edu.booking.config;

import com.example.edu.booking.exception.UnAuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class Crypt {
  private static final Logger logger = LoggerFactory.getLogger(Crypt.class);
  private static final String CRYPT_KEY;

  static {
    CRYPT_KEY = UUID.randomUUID().toString();
  }

  private Crypt() {
    // ユーティリティメソッドのため、インスタンス化を禁止します.
  }

  public static String encode(final String input) {
    var bytes = (CRYPT_KEY + "," + input).getBytes(StandardCharsets.UTF_8);
    var encoded = Base64.getEncoder().encodeToString(bytes);
    logger.debug("encode: input={}, result={}", input, encoded);
    return encoded;
  }

  public static String decode(final String encoded) {
    var decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
    if (!decoded.startsWith(CRYPT_KEY)) {
      logger.info("decode error: input={}", encoded);
      throw new UnAuthorizationException();
    }
    logger.debug("decode: input={}, result={}", encoded, decoded);
    return decoded.replaceAll(CRYPT_KEY + ",", "");
  }
}
