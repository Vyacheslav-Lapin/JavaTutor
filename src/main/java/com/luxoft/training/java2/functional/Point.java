package com.luxoft.training.java2.functional;

import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Value
public final class Point implements Serializable {
  int x;
  int y;
}
