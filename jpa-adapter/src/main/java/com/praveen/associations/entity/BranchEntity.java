package com.praveen.associations.entity;

import com.praveen.associations.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch")
public class BranchEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_ID_SEQUENCE")
  @SequenceGenerator(
      name = "BRANCH_ID_SEQUENCE",
      sequenceName = "BRANCH_ID_SEQUENCE",
      allocationSize = 1)
  private Integer id;

  @Column(name = "branch_name")
  private String name;

  @Column(name = "course_duration")
  private Integer duration;

  public static BranchEntity fromModel(Branch branch) {

    return BranchEntity.builder()
        .id(branch.getBranchId())
        .name(branch.getBranchName())
        .duration(branch.getDuration())
        .build();
  }

  public Branch toModel() {

    return Branch.builder().branchId(id).branchName(name).duration(duration).build();
  }
}
