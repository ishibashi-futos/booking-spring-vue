package com.example.edu.booking.booking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
  @Bean
  public ModelMapper getModelMapper() {
    var mapper = new ModelMapper();
    return mapper;
  }
}
