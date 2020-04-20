package com.example.edu.booking.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookingJpaRepositoryTest {
  @Autowired
  private BookingJpaRepository bookingJpaRepository;
  private List<Booking> dataset;
  @BeforeEach
  void init() {
    this.bookingJpaRepository.deleteAll();
    this.dataset = new ArrayList<Booking>();
    dataset.add(new Booking(UUID.randomUUID().toString(), "ROOM-1", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2), LocalDateTime.now().plusDays(-1), "user01"));
    dataset.add(new Booking(UUID.randomUUID().toString(), "ROOM-1", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4), LocalDateTime.now().plusDays(-1), "user01"));
    dataset.add(new Booking(UUID.randomUUID().toString(), "ROOM-1", LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(6), LocalDateTime.now().plusDays(-1), "user01"));
    dataset.add(new Booking(UUID.randomUUID().toString(), "ROOM-1", LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(8), LocalDateTime.now().plusDays(-1), "user01"));
    dataset.add(new Booking(UUID.randomUUID().toString(), "ROOM-1", LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(8), LocalDateTime.now().plusDays(-1), "user02"));
    this.bookingJpaRepository.saveAll(dataset);
    this.bookingJpaRepository.flush();
  }

  @Test
  public void findAll() {
    //var dataList = this.bookingJpaRepository.findByCreateUserIdOrderByStartDate("user01");
    var dataList = this.bookingJpaRepository.findAll();
    Assertions.assertEquals(dataset.size(), dataList.size());
  }

  @Test
  public void findByUserId() {
    var dataList = this.bookingJpaRepository.findByCreateUserIdOrderByStartDate("user02");
    Assertions.assertAll("check dataset",
      () -> Assertions.assertEquals(this.dataset.stream().filter(b -> b.getCreateUserId().equals("user02")).count(), dataList.size()),
      () -> Assertions.assertAll("data[0]", () -> {
        var data = dataList.get(0);
        var expect = this.dataset.get(4);
        Assertions.assertEquals(expect.getCreateUserId(), data.getCreateUserId());
        Assertions.assertEquals(expect.getStartDate(), data.getStartDate());
        Assertions.assertEquals(expect.getEndDate(), data.getEndDate());
        Assertions.assertEquals(expect.getRoomId(), data.getRoomId());
        })
    );
  }
}
