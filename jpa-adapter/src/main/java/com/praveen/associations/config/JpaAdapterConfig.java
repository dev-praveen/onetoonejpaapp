package com.praveen.associations.config;

import com.praveen.associations.dao.BranchDao;
import com.praveen.associations.dao.StudentDao;
import com.praveen.associations.port.ObtainCollegeRepository;
import com.praveen.associations.repository.CollegeRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.praveen.associations.entity")
@EnableJpaRepositories("com.praveen.associations.dao")
public class JpaAdapterConfig {

  @Bean
  public ObtainCollegeRepository getCollegeRepository(BranchDao branchDao, StudentDao studentDao) {

    return new CollegeRepository(branchDao, studentDao);
  }
}
