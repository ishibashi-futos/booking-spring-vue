package com.example.edu.booking.booking.domain.model;

import com.example.edu.booking.booking.infrastructure.BookingJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultBookingRepository implements BookingRepository {
  private final BookingJpaRepository repository;
  private final ModelMapper mapper;

  public DefaultBookingRepository(final BookingJpaRepository repository, final ModelMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<BookingEntity> findByUserId(String userId) {
    var bookingList = this.repository.findByCreateUserIdOrderByStartDate(userId);
    var typeToken = new TypeToken<List<BookingEntity>>() {
    }.getType();
    return this.mapper.map(bookingList, typeToken);
  }
}
