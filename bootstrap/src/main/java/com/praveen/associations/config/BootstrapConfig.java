package com.praveen.associations.config;

import com.praveen.associations.domain.CollegeDomain;
import com.praveen.associations.port.ObtainCollegeRepository;
import com.praveen.associations.port.RequestCollege;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaAdapterConfig.class)
@ComponentScan(basePackages = {"com.praveen.associations"})
public class BootstrapConfig {

  @Bean
  public RequestCollege requestCollege(ObtainCollegeRepository collegeRepository) {

    return new CollegeDomain(collegeRepository);
  }
}
