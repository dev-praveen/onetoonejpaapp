package com.praveen.associations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.praveen.associations.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class StudentEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_SEQUENCE")
  @SequenceGenerator(
      name = "STUDENT_ID_SEQUENCE",
      sequenceName = "STUDENT_ID_SEQUENCE",
      allocationSize = 1)
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_of_admission")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDate dateOfAdmission;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_of_birth")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDate dateOfBirth;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(
      name = "fk_branch_id",
      referencedColumnName = "id",
      nullable = false,
      insertable = false,
      updatable = false)
  private BranchEntity branch;

  public static StudentEntity fromModel(Student student) {

    return StudentEntity.builder()
        .id(student.getStudentId())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .branch(BranchEntity.fromModel(student.getBranch()))
        .dateOfAdmission(student.getDateOfAdmission())
        .dateOfBirth(student.getDateOfBirth())
        .build();
  }

  public Student toModel() {

    return Student.builder()
        .studentId(id)
        .firstName(firstName)
        .lastName(lastName)
        .dateOfAdmission(dateOfAdmission)
        .dateOfBirth(dateOfBirth)
        .build();
  }
}
