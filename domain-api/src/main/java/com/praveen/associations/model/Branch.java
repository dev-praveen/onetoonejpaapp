package com.praveen.associations.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Branch {

  private Integer branchId;

  @NotNull(message = "branch name can't be empty")
  private String branchName;

  @Min(value = 2, message = "minimum course duration is 2 years")
  @Max(value = 4, message = "maximum course duration is 4 years")
  private Integer duration;
}
