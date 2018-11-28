package com.luxoft.domain.account;

import com.luxoft.exceptions.NoEnoughFundsException;
import lombok.SneakyThrows;

import static com.luxoft.domain.account.AccountType.SAVING;

public class SavingAccount extends AbstractAccount {

	public SavingAccount(final int id, final double amount) {
		super(id, amount, AccountState.OPENED);
	}

	@Override
	public void deposit(final double amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount can not be negative");
		}
		this.balance += amount;
	}

	@Override
	@SneakyThrows
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount can not be negative");
		}
		if (this.balance - amount >= 0)
			this.balance -= amount;
		else
			throw new NoEnoughFundsException(amount);

	}

	public AccountType getAccountType() {
		return SAVING;
	}

	//TODO: implement toString method which details this account information
}
