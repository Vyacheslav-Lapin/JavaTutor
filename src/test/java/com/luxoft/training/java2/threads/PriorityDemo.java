package com.luxoft.training.java2.threads;

import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class PriorityDemo {

  public static void main(String... __) {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    Clicker hi = new Clicker();
    Clicker lo = new Clicker();

    hi.setPriority(Thread.MAX_PRIORITY);
    lo.setPriority(Thread.MIN_PRIORITY);

    hi.start();
    lo.start();

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted.");
    }

    hi.stopClick();
    lo.stopClick();

    try {
      hi.join();
      lo.join();
    } catch (InterruptedException e) {
      System.out.println("InterruptedException caught");
    }
    System.out.println("Low-priority thread:  " + lo.click);
    System.out.println("High-priority thread: " + hi.click);
    int x = hi.click - lo.click;
    System.out.println(x);

  }
}
