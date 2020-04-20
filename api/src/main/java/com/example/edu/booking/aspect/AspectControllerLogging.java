package com.example.edu.booking.aspect;

import com.example.edu.booking.utility.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class AspectControllerLogging {

  private StopWatch stopWatch;

  @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.GetMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.PostMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.PutMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.PatchMapping)")
  public void before(JoinPoint joinPoint) {
    if (JoinPoint.METHOD_EXECUTION.equals(joinPoint.getKind())) {
      var clazz = joinPoint.getTarget().getClass();
      this.stopWatch = new StopWatch(clazz);
    }
  }

  @After("@annotation(org.springframework.web.bind.annotation.RequestMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.GetMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.PostMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.PutMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping) "
    + "|| @annotation(org.springframework.web.bind.annotation.PatchMapping)")
  public void after(JoinPoint jp) {
    if (Objects.nonNull(this.stopWatch)) {
      this.stopWatch.close();
    }
  }
}
