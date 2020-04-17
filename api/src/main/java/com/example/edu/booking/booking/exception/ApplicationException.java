package com.example.edu.booking.booking.exception;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException {
  protected static int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
  public abstract int getStatusCode();
}
