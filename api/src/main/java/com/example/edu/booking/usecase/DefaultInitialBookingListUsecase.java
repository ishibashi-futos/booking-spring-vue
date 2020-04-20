package com.example.edu.booking.usecase;

import com.example.edu.booking.request.BookingListRequest;
import com.example.edu.booking.response.BookingListResponse;

import java.util.List;

public class DefaultInitialBookingListUsecase implements InitialBookingListUsecase {
  @Override
  public List<BookingListResponse> execute(BookingListRequest request) {
    return null;
  }
}
