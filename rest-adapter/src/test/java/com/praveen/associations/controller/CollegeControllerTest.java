package com.praveen.associations.controller;

import com.praveen.associations.model.Student;
import com.praveen.associations.port.RequestCollege;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
// @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootTest(classes = OneToOneJpaTestApplication.class, webEnvironment = RANDOM_PORT)
class CollegeControllerTest {

  private static final String STUDENTS_API_URI = "/college/api/v1/students";
  private static final String LOCALHOST = "http://localhost:";
  @Autowired RequestCollege requestCollege;
  @LocalServerPort private int port;
  @Autowired private TestRestTemplate testRestTemplate;

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}

  @Test
  void shouldGetAllStudents() {

    // Given
    when(requestCollege.getAllStudents()).thenReturn(getStudentsList());

    // When
    final var url = LOCALHOST + port + STUDENTS_API_URI;
    final var response =
        testRestTemplate.exchange(
            url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});

    // Then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(Objects.requireNonNull(response.getBody())).hasSize(2);
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
