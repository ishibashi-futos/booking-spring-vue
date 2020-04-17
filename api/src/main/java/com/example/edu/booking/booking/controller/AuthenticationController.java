package com.example.edu.booking.booking.controller;

import com.example.edu.booking.booking.request.AuthenticationRequest;
import com.example.edu.booking.booking.response.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  @ResponseStatus(code = HttpStatus.CREATED)
  public AuthenticationResponse auth(@RequestBody AuthenticationRequest request) {
    return new AuthenticationResponse(request.getUsername() + ":" + request.getPassword());
  }
}
