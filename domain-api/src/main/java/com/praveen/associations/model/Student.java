package com.praveen.associations.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class Student {

  private Integer studentId;

  @NotNull(message = "first name can't be empty")
  private String firstName;

  @NotNull(message = "last name can't be empty")
  private String lastName;

  private LocalDate dateOfAdmission;

  @NotNull(message = "DOB is mandatory to provide")
  private LocalDate dateOfBirth;

  private Branch branch;
}
