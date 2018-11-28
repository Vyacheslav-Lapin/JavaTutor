package com.luxoft.domain.client;

import java.io.Serializable;
import java.util.*;

import com.luxoft.domain.account.Account;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Builder
@ToString
@EqualsAndHashCode(exclude = "accounts")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class Client implements Serializable {

	@Getter
	String name;
	Gender gender;

	@Singular
	List<Account> accounts;

	public String getSalutation() {
		return gender != null ?
				gender.getSalutation() + " " + name
				: name;
	}

//	public Optional<Account> getAccount(int id) {
//		return accounts.stream()
//				.parallel()
//				.filter(account -> account.getAccountNumber() == id)
//				.findAny();
//	}

	public Optional<Account> getAccount(int id) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == id) {
				return Optional.of(account);
			}
		}
		return Optional.empty();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public List<Account> getAccountsList() {
		return Collections.unmodifiableList(accounts);
	}
}
