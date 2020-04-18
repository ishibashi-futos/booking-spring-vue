package com.example.edu.booking.booking.request;

import com.example.edu.booking.booking.usecase.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingListRequest implements Request {
  private String username;
}
