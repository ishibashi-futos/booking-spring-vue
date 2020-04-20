package com.example.edu.booking.domain.model;

import com.example.edu.booking.infrastructure.Booking;
import com.example.edu.booking.infrastructure.BookingJpaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Tag("repository")
class DefaultBookingRepositoryTest {
  @Mock
  private BookingJpaRepository jpaRepository;
  // ModelMapperはMock化できないので初期化する.
  private final ModelMapper mapper = new ModelMapper();
  private DefaultBookingRepository targetRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
    this.targetRepository = new DefaultBookingRepository(jpaRepository, mapper);
  }

  @Test
  public void findByUserIdIsNull() {
    Mockito.when(jpaRepository.findByCreateUserIdOrderByStartDate(null)).thenReturn(new ArrayList<>());
    var result = this.targetRepository.findByUserId(null);
    Assertions.assertThat(result.size()).isEqualTo(0);
  }

  @Test
  public void findByUserId() {
    var bookingList = new ArrayList<Booking>();
    bookingList.add(new Booking(UUID.randomUUID().toString(), "x000", LocalDateTime.now(), LocalDateTime.now().plusHours(1), LocalDateTime.now().plusDays(-1), "ishibashi.futos"));
    bookingList.add(new Booking(UUID.randomUUID().toString(), "x001", LocalDateTime.now(), LocalDateTime.now().plusHours(2), LocalDateTime.now().plusDays(-2), "ishibashi.futos"));
    bookingList.add(new Booking(UUID.randomUUID().toString(), "x002", LocalDateTime.now(), LocalDateTime.now().plusHours(3), LocalDateTime.now().plusDays(-3), "ishibashi.futos"));
    Mockito.when(jpaRepository.findByCreateUserIdOrderByStartDate("ishibashi.futos")).thenReturn(bookingList);
    var actuals = this.targetRepository.findByUserId("ishibashi.futos");
    for (var i = 0; i < bookingList.size(); i++) {
      var expect = bookingList.get(i);
      var actual = actuals.get(i);
      Assertions.assertThat(actual.getId()).isEqualTo(expect.getId());
      Assertions.assertThat(actual.getCreateDate()).isEqualTo(expect.getCreateDate());
      Assertions.assertThat(actual.getEndDate()).isEqualTo(expect.getEndDate());
      Assertions.assertThat(actual.getCreateDate()).isEqualTo(expect.getCreateDate());
      Assertions.assertThat(actual.getCreateUserId()).isEqualTo(expect.getCreateUserId());
    }
  }
}
