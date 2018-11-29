package com.luxoft.training.java2.functional;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest { //for com.luxoft.training.java2.functional.Line

  static final File FILE = new File("./file");

  @AfterEach
  void tearDown() {
    if (FILE.exists()) {
      //noinspection ResultOfMethodCallIgnored
      FILE.delete();
    }
  }

//  @NotNull
//  @SneakyThrows
//  @Contract(pure = true)
//  public final void withObjectOutputStrream(@NotNull Consumer<ObjectOutputStream> objectOutputStreamConsumer) {
//    @Cleanup ObjectOutputStream objectOutputStream =
//        new ObjectOutputStream(
//            new FileOutputStream(FILE));
//
//    objectOutputStreamConsumer.accept(objectOutputStream);
//  }
  
  
  
  @Test
  @SneakyThrows
  @DisplayName("\"Name\" method works correctly")
  void testName() {
    // given
    val line = new Line(new Point(1, 1),
        new Point(2, 2),
        1);

    // when
    val byteArrayOutputStream = new ByteArrayOutputStream();
    @Cleanup val objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(line);

    @Cleanup ObjectInputStream objectInputStream = new ObjectInputStream(
        new ByteArrayInputStream(
            byteArrayOutputStream.toByteArray()));

    // then
    assertThat(((Line) objectInputStream.readObject()).getPoint1().getX())
        .isEqualTo(1);

  }
}