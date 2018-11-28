package com.luxoft.domain;

import com.luxoft.domain.client.Client;
import lombok.*;
import org.checkerframework.checker.propkey.qual.PropertyKey;

import java.util.List;

@Value
@Builder // @AllArgsConstructor(access = PRIVATE)
@Getter(onMethod = @__(@PropertyKey))
//@AllArgsConstructor(onConstructor = @__(@PropertyKey))
public final class Bank {

  String name;

  @Singular
  List<Client> clients;
}
