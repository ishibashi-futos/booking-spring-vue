package com.example.edu.booking.response;

import com.example.edu.booking.usecase.Response;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class BookingListResponse implements Response {
  public final String roomId;
  public final String roomName;
  public final LocalDateTime startDate;
  public final LocalDateTime endDate;
  public final String username;
}
