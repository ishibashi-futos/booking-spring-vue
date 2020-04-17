package com.example.edu.booking.booking.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest implements Request {
  private String username;
  private String password;
}
