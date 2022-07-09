package com.praveen.associations.controller;

import com.praveen.associations.port.RequestCollege;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootApplication
public class OneToOneJpaTestApplication {

  @MockBean private RequestCollege requestCollege;

  public static void main(String[] args) {
    SpringApplication.run(OneToOneJpaTestApplication.class, args);
  }
}
