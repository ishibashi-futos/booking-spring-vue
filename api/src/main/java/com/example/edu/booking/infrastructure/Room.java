package com.example.edu.booking.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOMS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {
  @Id
  @Column
  private String roomId;
  @Column
  private String roomName;
}
