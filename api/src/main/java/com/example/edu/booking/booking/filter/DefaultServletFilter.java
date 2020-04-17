package com.example.edu.booking.booking.filter;

import com.example.edu.booking.booking.config.Crypt;
import com.example.edu.booking.booking.thread.ThreadLocalHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DefaultServletFilter extends OncePerRequestFilter {
  private static final Logger logger = LoggerFactory.getLogger(DefaultServletFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    logger.info("doFilterInternal start: request={}", request);
    if (!request.getRequestURI().startsWith("/auth")) {
      var authHeader = request.getHeader("Authorization");
      var decoded = Crypt.decode(authHeader);
      logger.info("auth header: input={}, decoded={}", authHeader, decoded);
      var map = ThreadLocalHolder.get();
      map.put("auth", decoded);
    }
    filterChain.doFilter(request, response);
    logger.info("doFilterInternal end: response={}", response);
  }
}
