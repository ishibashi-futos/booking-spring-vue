package com.example.edu.booking.booking.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class StopWatch implements Closeable {
  private final static Logger logger = LoggerFactory.getLogger(StopWatch.class);
  private final LocalDateTime startTime;
  private final String targetClassName;
  public StopWatch(Class<?> clazz) {
    this.targetClassName = clazz.getName();
    this.startTime = LocalDateTime.now();
    logger.debug("stopwatch start: target={}, startTime={}", this.targetClassName, this.startTime);
  }

  public void close() {
    var endTime = LocalDateTime.now();
    logger.debug("stopwatch stop: target={}, endTime={}", targetClassName, endTime);
    logger.info("stopwatch diff: target={}, diff={}", targetClassName, ChronoUnit.MILLIS.between(startTime, endTime));
  }
}
