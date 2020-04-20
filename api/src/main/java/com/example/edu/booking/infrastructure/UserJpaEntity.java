package com.example.edu.booking.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJpaEntity {
  @Id
  @Column(name = "user_id")
  private String id;

  @Column(name = "user_name")
  private String name;
}
