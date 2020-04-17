package com.example.edu.booking.booking.response;

public class AuthenticationResponse implements Response {
  public final String token;

  public AuthenticationResponse(final String token) {
    this.token = token;
  }
}
