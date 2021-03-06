package com.luxoft.domain.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public enum Gender {
  MALE("Mr."),
  FEMALE("Ms.");

  String salutation;
}
