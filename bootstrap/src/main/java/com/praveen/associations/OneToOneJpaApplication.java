package com.praveen.associations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.praveen.associations.config"})
public class OneToOneJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(OneToOneJpaApplication.class, args);
  }
}
