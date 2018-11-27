package com.luxoft.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

//@Value // @FieldDefaults(level = PRIVATE, makeFinal = true), @Getter, @EqualsAndHashCode, @ToString, @AllArgsConstructor
//@Accessors(chain = true)
@Slf4j
@Data // @Setter, @Getter, @EqualsAndHashCode, @ToString, @RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class Person {

  public static void main(String... __) {
    log.info("Мама мыла раму");
  }

  String firstName;
  LocalDate dob;
  List<String> contacts;

  @NonFinal
  @Setter
  String lastName;
}
