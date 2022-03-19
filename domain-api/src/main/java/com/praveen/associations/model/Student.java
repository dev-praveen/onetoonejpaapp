package com.praveen.associations.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Student {

  private Integer studentId;
  private String firstName;
  private String lastName;
  private LocalDate dateOfAdmission;
  private LocalDate dateOfBirth;
  private Branch branch;
}
