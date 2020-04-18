package com.example.edu.booking.booking.domain.model;

import java.util.List;

public interface BookingRepository {
  List<BookingEntity> findByUserId(String userId);
}
