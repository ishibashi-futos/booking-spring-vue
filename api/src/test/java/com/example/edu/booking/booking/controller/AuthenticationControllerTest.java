package com.example.edu.booking.booking.controller;

import com.example.edu.booking.booking.request.AuthenticationRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class AuthenticationControllerTest {

  @InjectMocks
  private AuthenticationController controller;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  public void getLogin() throws Exception {
    var request = new AuthenticationRequest();
    request.setUsername("ishibashi.futos");
    request.setPassword("P@s5w0rd");
    var response = this.controller.auth(request);
    Assertions.assertAll("permitted",
      () -> Assertions.assertEquals(response.token, request.getUsername() + ":" + request.getPassword())
    );
  }
}
