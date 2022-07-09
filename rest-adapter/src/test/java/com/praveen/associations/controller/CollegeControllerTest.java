package com.praveen.associations.controller;

import com.praveen.associations.model.Student;
import com.praveen.associations.port.RequestCollege;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CollegeController.class)
class CollegeControllerTest {

  @MockBean RequestCollege requestCollege;
  @Autowired MockMvc mockMvc;

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}

  @Test
  void shouldGetAllStudents() throws Exception {

    when(requestCollege.getAllStudents()).thenReturn(getStudentsList());
    mockMvc.perform(get("/college/api/v1/students")).andExpect(status().is2xxSuccessful());
  }

  private List<Student> getStudentsList() {

    final var student1 =
        Student.builder()
            .studentId(100)
            .firstName("praveen")
            .lastName("sana")
            .dateOfBirth(LocalDate.of(1991, Month.APRIL, 16))
            .build();

    final var student2 =
        Student.builder()
            .studentId(110)
            .firstName("dattu")
            .lastName("naga")
            .dateOfBirth(LocalDate.of(1993, Month.NOVEMBER, 17))
            .build();
    return List.of(student1, student2);
  }
}
