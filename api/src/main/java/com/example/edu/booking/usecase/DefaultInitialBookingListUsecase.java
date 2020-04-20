package com.example.edu.booking.usecase;

import com.example.edu.booking.domain.model.BookingRepository;
import com.example.edu.booking.request.BookingListRequest;
import com.example.edu.booking.response.BookingListResponse;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultInitialBookingListUsecase implements InitialBookingListUsecase {
  private final BookingRepository bookingRepository;

  public DefaultInitialBookingListUsecase(final BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Override
  public List<BookingListResponse> execute(BookingListRequest request) {
    var bookingList = this.bookingRepository.findByUserId(request.getUsername());
    return bookingList.stream().parallel()
      .map(v -> new BookingListResponse(v.getRoomId(), v.getRoomName(), v.getStartDate(), v.getEndDate(), v.getCreateUserName())
      ).collect(Collectors.toList());
  }
}
