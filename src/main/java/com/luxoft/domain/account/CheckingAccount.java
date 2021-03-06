package com.luxoft.domain.account;

import com.luxoft.exceptions.NoEnoughFundsException;
import com.luxoft.exceptions.OverDraftLimitExceededException;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

import static com.luxoft.domain.account.AccountState.OPENED;
import static com.luxoft.domain.account.AccountType.CHECKING;
import static lombok.AccessLevel.PRIVATE;

@ToString
@FieldDefaults(level = PRIVATE)
public class CheckingAccount extends AbstractAccount {

  @Getter
  double overdraft = 10_000;

  public CheckingAccount(int id, double amount, double overdraft) {
    super(id, amount, OPENED);
    this.overdraft = overdraft;
  }

  @Override
  @SneakyThrows
  public void withdraw(double amount) {

    if (amount < 0)
      throw new IllegalArgumentException("Amount can not be negative");

    if (this.balance - amount >= -overdraft)
      this.balance -= amount;
    else
      throw new NoEnoughFundsException(amount);

    if (this.balance < amount) {
      // Not enough balance to cover the amount requested to withdraw
      // Check if there is enough in the overdraft protection (if any)
      double overdraftNeeded = amount - this.balance;
      if (overdraft < overdraftNeeded) {
        throw new OverDraftLimitExceededException(overdraftNeeded
            - overdraft);
      } else {
        // Yes, there is overdraft protection and enough to cover the amount
        this.balance = 0.0;
        overdraft -= overdraftNeeded;
      }
    } else {
      // Yes, there is enough balance to cover the amount
      // Proceed as usual
      this.balance = this.balance - amount;
    }


  }

  @Override
  public void deposit(double amount) {
    if (amount > 0)
      this.balance += amount;
    else
      throw new IllegalArgumentException("amount ca not be negative");
  }

  //TODO: implement toString method which details this account information

  @NotNull
  @Override
  public AccountType getAccountType() {
    return CHECKING;
  }
}
