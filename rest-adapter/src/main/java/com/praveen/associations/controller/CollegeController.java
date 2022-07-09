package com.praveen.associations.controller;

import com.praveen.associations.model.Student;
import com.praveen.associations.port.RequestCollege;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/college/api/v1")
public class CollegeController {

  private final RequestCollege requestCollege;

  @GetMapping("/students")
  public ResponseEntity<List<Student>> getAllStudents() {

    final var studentList = requestCollege.getAllStudents();
    return ResponseEntity.ok(studentList);
  }

  @PostMapping("/student")
  public ResponseEntity<Void> saveStudent(@RequestBody @Valid Student student) {

    requestCollege.saveStudent(student);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/student/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Integer studentId) {

    final var student = requestCollege.getStudentById(studentId);
    return ResponseEntity.ok(student);
  }
}
