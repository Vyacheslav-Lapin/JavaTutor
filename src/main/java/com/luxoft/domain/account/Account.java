package com.luxoft.domain.account;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Account {

  void deposit(double amount);

  void withdraw(double amount);

  int getAccountNumber();

  AccountType getAccountType();

  boolean isOpened();

  double getBalance();

  long decimalValue();

  default int m1() {
    int x;
    x = 5;
    //...
    return 0;
  }

  @Contract(pure = true)
  private int m2() {
    int x;
    x = 5;
    //...
    return 0;
  }


}
