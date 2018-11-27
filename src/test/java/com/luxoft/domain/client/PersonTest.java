package com.luxoft.domain.client;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class PersonTest { //for com.luxoft.domain.client.Person

  @Test
  @SneakyThrows
  @DisplayName("\"Name\" method works correctly")
  void testName() {
    // given

    // when

    // then
    val person = new Person("Вася",
        LocalDate.now(),
        List.of("222-33-22"),
        "Смирнова");

    System.out.println(person.setLastName("Долгожданова")); // Вася
    System.out.println(person.getDob()); // Вася
    System.out.println(person); // Вася...
  }
}