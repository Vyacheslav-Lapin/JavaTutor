package com.luxoft.domain.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public enum AccountType {
  SAVING("saving"),
  CHECKING("checking");

  String type;
}
