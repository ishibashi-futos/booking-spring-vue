package com.example.edu.booking.controller;

import com.example.edu.booking.config.Crypt;
import com.example.edu.booking.request.AuthenticationRequest;
import com.example.edu.booking.response.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  @ResponseStatus(code = HttpStatus.CREATED)
  public AuthenticationResponse auth(@RequestBody AuthenticationRequest request) {
    return new AuthenticationResponse(Crypt.encode(request.getUsername()));
  }
}
