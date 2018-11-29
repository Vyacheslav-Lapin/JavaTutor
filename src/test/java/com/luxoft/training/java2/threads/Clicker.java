package com.luxoft.training.java2.threads;

import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class Clicker extends Thread {

  protected int click = 0;
  volatile boolean running = true;

  @Override
  public void run() {
    while (running)
      click++;
  }

  public void stopClick() {
    running = false;
  }
}
