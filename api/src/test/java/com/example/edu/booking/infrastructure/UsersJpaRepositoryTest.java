package com.example.edu.booking.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UsersJpaRepositoryTest {

  @Autowired
  private UsersJpaRepository repository;
  private final static List<UserJpaEntity> dataset = new ArrayList<>() {
    {
      add(new UserJpaEntity("ishibashi.futos", "ishibashi, futoshi"));
    }
  };

  @BeforeEach
  public void init() {
    this.repository.deleteAll();
    this.repository.saveAll(dataset);
    this.repository.flush();
  }

  @Test
  public void findByUserId() {
    this.repository.findById("ishibashi.futos").ifPresentOrElse(v -> {
      Assertions.assertAll("userIdと名称が一致する",
        () -> Assertions.assertEquals("ishibashi.futos", v.getId()),
        () -> Assertions.assertEquals("ishibashi, futoshi", v.getName())
      );
    }, Assertions::fail);
  }
}
