package com.luxoft.training.java2.module1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.luxoft.training.Logger.log;
import static org.assertj.core.api.Assertions.assertThat;

class ObjectToStringTutorTest {

  static final ObjectToStringTutor.Employee EMPLOYEE1 = new ObjectToStringTutor.Employee("Иван", "Иванов", 35);

  @Test
  void testEmployees() {

    // given, when
    List<ObjectToStringTutor.Employee> employees =
        getEmployees();

    // then
    assertThat(employees)
        .hasSize(4)
        .contains(EMPLOYEE1);

//    int index = 0;
//    for (ObjectToStringTutor.Employee employee : employees) {
//      log(String.format("emp%d=%s", index++, employee));
//    }

  }

  List<ObjectToStringTutor.Employee> getEmployees() {
    return Arrays.asList(
        EMPLOYEE1,
        new ObjectToStringTutor.Employee("Иван", "Иванов", 30),
        new ObjectToStringTutor.Employee("Иван", "Петров", 25),
        new ObjectToStringTutor.Employee("Иван", "Сидоров", 25));
  }
}