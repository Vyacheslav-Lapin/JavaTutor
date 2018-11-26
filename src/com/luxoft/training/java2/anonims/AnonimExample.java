package com.luxoft.training.java2.anonims;

import java.util.Date;

public final class AnonimExample {

  public static void main(String... __) {
    var date = new Date(0) {
      @Override
      public long getTime() {
        long time = super.getTime();
        return time == 0 ? Long.MAX_VALUE: time;
      }

      String m1() {
        return "Hello, World!";
      }
    };

    System.out.println(date.getTime() == Long.MAX_VALUE); // true

    System.out.println("date.m1() = " + date.m1()); // "Hello, World!"

//    new Outer().new Inner();
//    new Outer.Inner();
  }
}
