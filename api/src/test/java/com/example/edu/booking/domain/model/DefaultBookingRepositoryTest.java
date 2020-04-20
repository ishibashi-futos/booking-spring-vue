package com.example.edu.booking.domain.model;

import com.example.edu.booking.infrastructure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag("repository")
class DefaultBookingRepositoryTest {
  @Mock
  private BookingJpaRepository jpaRepository;
  @Mock
  private RoomJpaRepository roomJpaRepository;
  @Mock
  private UsersJpaRepository usersJpaRepository;
  // ModelMapperはMock化できないので初期化する.
  private final ModelMapper mapper = new ModelMapper();
  private DefaultBookingRepository targetRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
    this.targetRepository = new DefaultBookingRepository(jpaRepository, roomJpaRepository, usersJpaRepository, mapper);
  }

  @Test
  public void findByUserIdIsNull() {
    Mockito.when(jpaRepository.findByCreateUserIdOrderByStartDate(null)).thenReturn(new ArrayList<>());
    var result = this.targetRepository.findByUserId(null);
    Assertions.assertEquals(result.size(), 0);
  }

  @Test
  public void findByUserId() {
    var bookingList = new ArrayList<Booking>();
    bookingList.add(new Booking(UUID.randomUUID().toString(), "x000", LocalDateTime.now(), LocalDateTime.now().plusHours(1), LocalDateTime.now().plusDays(-1), "ishibashi.futos"));
    bookingList.add(new Booking(UUID.randomUUID().toString(), "x001", LocalDateTime.now(), LocalDateTime.now().plusHours(2), LocalDateTime.now().plusDays(-2), "ishibashi.futos"));
    bookingList.add(new Booking(UUID.randomUUID().toString(), "x002", LocalDateTime.now(), LocalDateTime.now().plusHours(3), LocalDateTime.now().plusDays(-3), "ishibashi.futos"));
    Mockito.when(jpaRepository.findByCreateUserIdOrderByStartDate("ishibashi.futos")).thenReturn(bookingList);
    Mockito.when(roomJpaRepository.findById("x000")).thenReturn(Optional.of(new Room("x000", "room001")));
    Mockito.when(roomJpaRepository.findById("x001")).thenReturn(Optional.of(new Room("x001", "room001")));
    Mockito.when(roomJpaRepository.findById("x002")).thenReturn(Optional.of(new Room("x002", "room001")));
    Mockito.when(usersJpaRepository.findById("ishibashi.futos")).thenReturn(Optional.of(new UserJpaEntity("ishibashi.futos", "ishibashi, futoshi")));
    var actuals = this.targetRepository.findByUserId("ishibashi.futos");
    Assertions.assertAll("collectionに対するテスト",
      () -> {
        var zero = actuals.get(0);
        Assertions.assertAll("0番目の項目に対するテスト",
          () -> Assertions.assertEquals(zero.getRoomName(), "room001"),
          () -> Assertions.assertEquals("ishibashi, futoshi", zero.getCreateUserName())
        );
      }
    );
  }

  @Test
  public void findByUserIdResultIsZero() {
    List<Booking> bookingList = new ArrayList<>();
    Mockito.when(jpaRepository.findByCreateUserIdOrderByStartDate("hoge")).thenReturn(bookingList);
    var resultSet = this.targetRepository.findByUserId("hoge");
    Assertions.assertEquals(0, resultSet.size());
  }
}
