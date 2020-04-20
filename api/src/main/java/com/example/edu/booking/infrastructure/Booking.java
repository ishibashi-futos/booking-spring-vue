package com.example.edu.booking.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String roomId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private LocalDateTime createDate;
  private String createUserId;
}
