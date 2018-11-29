package com.luxoft.domain.account;

import com.luxoft.exceptions.NoEnoughFundsException;
import lombok.SneakyThrows;
import lombok.ToString;

import static com.luxoft.domain.account.AccountState.OPENED;
import static com.luxoft.domain.account.AccountType.SAVING;

@ToString
public class SavingAccount extends AbstractAccount {

	public SavingAccount(int id, double amount) {
		super(id, amount, OPENED);
	}

	@Override
	public void deposit(double amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount can not be negative");
		}
		this.balance += amount;
	}

	@Override
	@SneakyThrows
	public void withdraw(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("Amount can not be negative");
		if (this.balance - amount >= 0)
			this.balance -= amount;
		else
			throw new NoEnoughFundsException(amount);

	}

	public AccountType getAccountType() {
		return SAVING;
	}
}
