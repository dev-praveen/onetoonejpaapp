package com.praveen.associations.repository;

import com.praveen.associations.dao.BranchDao;
import com.praveen.associations.dao.StudentDao;
import com.praveen.associations.entity.StudentEntity;
import com.praveen.associations.model.Student;
import com.praveen.associations.port.ObtainCollegeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CollegeRepository implements ObtainCollegeRepository {

  private final BranchDao branchDao;
  private final StudentDao studentDao;

  @Override
  public List<Student> fetchAllStudents() {

    final var students = studentDao.findAll();
    return students.stream().map(StudentEntity::toModel).collect(Collectors.toList());
  }

  @Override
  public Student getStudentById(Integer id) {

    final var student = studentDao.findById(id);
    return student.map(StudentEntity::toModel).orElseThrow();
  }

  @Override
  public void saveStudent(Student student) {

    final var studentEntity = StudentEntity.fromModel(student);
    studentDao.save(studentEntity);
  }
}
