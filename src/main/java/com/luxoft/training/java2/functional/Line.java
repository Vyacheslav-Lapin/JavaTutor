package com.luxoft.training.java2.functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class Line implements Serializable {

  Point point1;
  Point point2;
  int index;
}
