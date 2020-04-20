package com.example.edu.booking.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
  @Id
  @Column(length = 255)
  private String id;
  @Column(name = "room_id", length = 255)
  private String roomId;
  @Column(name = "start_date")
  private LocalDateTime startDate;
  @Column(name = "end_date")
  private LocalDateTime endDate;
  @Column(name = "create_date")
  private LocalDateTime createDate;
  @Column(name = "create_user_id", length = 255)
  private String createUserId;
}
