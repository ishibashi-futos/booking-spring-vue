package com.example.edu.booking.domain.model;

import com.example.edu.booking.infrastructure.BookingJpaRepository;
import com.example.edu.booking.infrastructure.RoomJpaRepository;
import com.example.edu.booking.infrastructure.UsersJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultBookingRepository implements BookingRepository {
  private final BookingJpaRepository bookingJpaRepository;
  private final RoomJpaRepository roomJpaRepository;
  private final UsersJpaRepository usersJpaRepository;
  private final ModelMapper mapper;

  public DefaultBookingRepository(final BookingJpaRepository bookingJpaRepository,
                                  final RoomJpaRepository roomJpaRepository,
                                  final UsersJpaRepository usersJpaRepository,
                                  final ModelMapper mapper) {
    this.bookingJpaRepository = bookingJpaRepository;
    this.roomJpaRepository = roomJpaRepository;
    this.usersJpaRepository = usersJpaRepository;
    this.mapper = mapper;
  }

  public List<BookingEntity> findByUserId(String userId) {
    var bookingList = this.bookingJpaRepository.findByCreateUserIdOrderByStartDate(userId);
    return bookingList.stream().parallel().map(booking -> {
      var mapped = this.mapper.map(booking, BookingEntity.class);
      this.roomJpaRepository.findById(booking.getRoomId()).ifPresent(v -> {
        mapped.setRoomName(v.getRoomName());
      });
      this.usersJpaRepository.findById(booking.getCreateUserId()).ifPresent(v -> mapped.setCreateUserName(v.getName()));
      return mapped;
    }).collect(Collectors.toList());
  }
}
