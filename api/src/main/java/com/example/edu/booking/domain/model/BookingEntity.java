package com.example.edu.booking.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingEntity extends StringIdentifierEntity {
  public String roomId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private LocalDateTime createDate;
  private String createUserId;

  @Override
  public boolean isTransient() {
    return this.isTransient;
  }

  @Override
  public void setTransient(boolean isTransient) {
    this.isTransient = isTransient;
  }
}
