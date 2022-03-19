package com.praveen.associations.domain;

import com.praveen.associations.model.Student;
import com.praveen.associations.port.ObtainCollegeRepository;
import com.praveen.associations.port.RequestCollege;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CollegeDomain implements RequestCollege {

  private final ObtainCollegeRepository obtainCollegeRepository;

  @Override
  public void saveStudent(Student student) {

    obtainCollegeRepository.saveStudent(student);
  }

  @Override
  public List<Student> getAllStudents() {
    return obtainCollegeRepository.fetchAllStudents();
  }

  @Override
  public Student getStudentById(Integer studentId) {
    return obtainCollegeRepository.getStudentById(studentId);
  }
}
