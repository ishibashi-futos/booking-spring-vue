package com.example.edu.booking.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizationException extends ApplicationException {
  protected static final int statusCode = HttpStatus.UNAUTHORIZED.value();

  @Override
  public int getStatusCode() {
    return statusCode;
  }
}
