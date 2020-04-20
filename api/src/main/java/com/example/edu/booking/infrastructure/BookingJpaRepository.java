package com.example.edu.booking.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingJpaRepository extends JpaRepository<Booking, String> {
  List<Booking> findByCreateUserIdOrderByStartDate(final String username);
}
