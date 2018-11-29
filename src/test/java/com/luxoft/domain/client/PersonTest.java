package com.luxoft.domain.client;

import lombok.SneakyThrows;
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
    val person = new Person("Вася",
        LocalDate.now(),
        List.of("222-33-22"),
        "Смирнова");

    // when

    // then
    System.out.println(person.setLastName("Долгожданова")); // Вася
    System.out.println(person.getDob()); // Вася
    System.out.println(person); // Вася...
  }
}