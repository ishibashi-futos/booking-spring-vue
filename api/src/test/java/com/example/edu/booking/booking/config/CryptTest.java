package com.example.edu.booking.booking.config;

import com.example.edu.booking.booking.exception.UnAuthorizationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.UUID;

class CryptTest {

  @Test
  public void cryptString() {
    var input = "ishibashi.futos,P@s5w0rd";
    var encoded = Crypt.encode(input);
    var decoded = Crypt.decode(encoded);
    Assertions.assertAll("endsWith",
      () -> Assertions.assertTrue(decoded.endsWith(input)),
      () -> Assertions.assertEquals(input, decoded)
    );
  }

  @Test
  public void decodeAuthorizeError() {
    var input = UUID.randomUUID().toString();
    Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
      () -> Crypt.decode(input));
  }

  @Test
  public void invalidError() {
    var uuid = UUID.randomUUID().toString();
    var input = "ishibashi.futos,P@s5w0rd";
    var encoded = Base64.getEncoder().encodeToString((uuid + "a," + input).getBytes());
    UnAuthorizationException exception = Assertions.assertThrows(UnAuthorizationException.class,
      () -> Crypt.decode(encoded));
    Assertions.assertEquals(exception.getStatusCode(), 401);
  }
}
