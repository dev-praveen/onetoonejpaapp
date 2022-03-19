package com.praveen.associations.port;

import com.praveen.associations.model.Student;

import java.util.List;

public interface RequestCollege {

  void saveStudent(Student student);

  List<Student> getAllStudents();

  Student getStudentById(Integer studentId);
}
