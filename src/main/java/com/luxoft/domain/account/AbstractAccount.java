package com.luxoft.domain.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor
@FieldDefaults(level = PROTECTED)
public abstract class AbstractAccount implements Account {

  int accountNumber;
  double balance;
  @Setter
  AccountState state;

  public static int getUniqueAccountNumber() {
    return (int) System.currentTimeMillis();
  }

  @Override
  public long decimalValue() {
    return Math.round(getBalance());
  }

  @Override
  public boolean isOpened() {
    return state == AccountState.OPENED;
  }
}
