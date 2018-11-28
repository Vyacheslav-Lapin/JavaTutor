package com.luxoft.domain;

import com.luxoft.domain.account.CheckingAccount;
import com.luxoft.domain.client.Client;
import com.luxoft.domain.client.Gender;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

import static com.luxoft.domain.client.Gender.MALE;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class BankApplication {

  public static void main(String... __) {

    var bank = Bank.builder()
        .name("Сбербанк")
        .client(Client.builder()
            .name("Вася")
            .gender(MALE)
//            .account(CheckingAccount.builder()
//                .overdraft(3_456)
//                .build())
            .account(new CheckingAccount(1, 10_000, 100_000))
            .build())
        .build();

    bank.getClients().stream()
        .flatMap(client -> client.getAccountsList().stream())
        .peek(account -> account.withdraw(50))
        .forEach(account -> System.out.println("account = " + account));

  }
}
