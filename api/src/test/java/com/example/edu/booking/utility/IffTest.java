package com.example.edu.booking.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IffTest {

  @Test
  public void testIf() {
    var result = new Iff<String, Integer>((str) -> str.startsWith("hoge"), () -> 100).eval("hogeFuga");
    Assertions.assertEquals(result.get(), 100);
  }

  @Test
  public void testIfElseFirstMatch() {
    var result = new Iff<String, Integer>((str) -> str.startsWith("hoge"), () -> 100)
      .elseIf((str) -> str.startsWith("hogeFuga"), () -> 200)
      .elseIf((str) -> str.startsWith("hoho"), () -> 300)
      .eval("hogeFuga");
    Assertions.assertEquals(result.get(), 100);
  }

  @Test
  public void noMatch() {
    var result = new Iff<String, Integer>((str) -> str.startsWith("hoge"), () -> 100)
      .elseIf((str) -> str.startsWith("hogeFuga"), () -> 200)
      .elseIf((str) -> str.startsWith("hoho"), () -> 300)
      .elsef(() -> 400)
      .eval(UUID.randomUUID().toString());
    Assertions.assertEquals(result.get(), 400);
  }

  @Test
  public void noMatchNotExistsElse() {
    var result = new Iff<String, Integer>((str) -> str.startsWith("hoge"), () -> 100)
      .elseIf((str) -> str.startsWith("hogeFuga"), () -> 200)
      .elseIf((str) -> str.startsWith("hoho"), () -> 300)
      .eval(UUID.randomUUID().toString());
    result.ifPresentOrElse(v -> {
      Assertions.fail();
    }, () -> {
      // elseだったら正解
    });
  }

  @Test
  public void elseResultIsNull() {
    final var result = new Iff<String, Integer>((str) -> str.startsWith("hoge"), () -> 100)
      .elseIf((str) -> str.startsWith("hogeFuga"), () -> 200)
      .elseIf((str) -> str.startsWith("hoho"), () -> 300)
      .elsef(() -> null)
      .eval(UUID.randomUUID().toString());
    Assertions.assertTrue(result.isEmpty());
  }

  @Test
  public void elseIfResultIsNull() {
    var result = new Iff<String, Integer>((str) -> str.startsWith("hoge"), () -> 100)
      .elseIf((str) -> str.startsWith("mogemoge"), () -> null)
      .elseIf((str) -> str.startsWith("hoho"), () -> 300)
      .elsef(() -> null)
      .eval("mogemoge");
    Assertions.assertTrue(result.isEmpty());
  }
}
