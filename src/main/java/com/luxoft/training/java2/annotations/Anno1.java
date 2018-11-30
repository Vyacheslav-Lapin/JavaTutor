package com.luxoft.training.java2.annotations;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Anno1 {
  int x() default 5;
  int y() default 15;

  /**
   * @aliase for {@link #predicate()}
   */
  String value() default "";

  String predicate() default "";
}
