package com.example.edu.booking.booking.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingJpaRepository extends JpaRepository<Booking, String> {
  List<Booking> findByCreateUserIdOrderByStartDate(final String username);
}
