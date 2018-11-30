package com.luxoft.training.java2.annotations;

import lombok.experimental.FieldDefaults;

import java.util.Arrays;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Anno1(
    ints = 42,
    predicate = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
public final class AnnotationExample {

  public static void main(String... __) {

    Anno1 annotation = AnnotationExample.class
        .getAnnotation(Anno1.class);

    String predicate = annotation.value().equals("") ?
        annotation.predicate()
        : annotation.value();

    System.out.println(predicate);
    System.out.println(annotation.x());
    System.out.println(Arrays.toString(annotation.ints()));
  }
}
