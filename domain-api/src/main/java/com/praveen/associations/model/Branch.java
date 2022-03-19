package com.praveen.associations.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Branch {

  private Integer branchId;
  private String branchName;
  private Integer duration;
}
