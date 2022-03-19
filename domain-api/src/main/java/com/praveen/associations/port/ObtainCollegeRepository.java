package com.praveen.associations.port;

import com.praveen.associations.model.Student;

import java.util.List;

public interface ObtainCollegeRepository {

  List<Student> fetchAllStudents();

  Student getStudentById(Integer id);

  void saveStudent(Student student);
}
