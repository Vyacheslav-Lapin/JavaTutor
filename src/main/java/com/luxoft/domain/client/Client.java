package com.luxoft.domain.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.luxoft.domain.account.Account;

public class Client implements Serializable {

	private String name;
	private Gender gender;

	private List<Account> accounts = new ArrayList<Account>();

	public Client(final String name, final Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getSalutation() {
		if (gender != null) {
			return gender.getSalutation() + " " + name;
		} else {
			return name;
		}
	}

	public Account getAccount(final int id) {
		for (Account acc : accounts) {
			if (acc.getAccountNumber() == id) {
				return acc;
			}
		}
		return null;
	}

	public void addAccount(final Account account) {
		accounts.add(account);
	}

	//TODO: implement toString method which outputs infor for this client

	public List<Account> getAccountsList() {
		return Collections.unmodifiableList(accounts);
	}

	//TODO: implement hashCode() and equals() methods which will be used in the following examples (collections)
}
