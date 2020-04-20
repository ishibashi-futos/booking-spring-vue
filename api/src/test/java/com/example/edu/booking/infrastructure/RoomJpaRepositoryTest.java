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
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomJpaRepositoryTest {
  @Autowired
  private RoomJpaRepository roomJpaRepository;
  private List<Room> dataset;

  @BeforeEach
  public void init() {
    this.roomJpaRepository.deleteAll();
    this.dataset = new ArrayList<>();
    this.dataset.add(new Room(UUID.randomUUID().toString(), "ROOM-1"));
    this.dataset.add(new Room(UUID.randomUUID().toString(), "ROOM-2"));
    this.dataset.add(new Room(UUID.randomUUID().toString(), "ROOM-3"));
    this.roomJpaRepository.saveAll(dataset);
    this.roomJpaRepository.flush();
  }

  @Test
  public void test() {
    var expect = dataset.get(0);
    this.roomJpaRepository.findById(expect.getRoomId()).ifPresentOrElse(room1 -> {
      Assertions.assertAll("room1",
        () -> Assertions.assertEquals(expect.getRoomId(), room1.getRoomId()),
        () -> Assertions.assertEquals(expect.getRoomName(), room1.getRoomName())
      );
    }, Assertions::fail);
  }
}
