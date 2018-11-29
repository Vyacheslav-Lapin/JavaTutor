package com.luxoft.training.java2.functional;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedFunction1;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

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

  @SneakyThrows
  @Contract(pure = true)
  final void withObjectOutputStrream(@NotNull CheckedConsumer<ObjectOutputStream> objectOutputStreamCheckedConsumer) {
    @Cleanup ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(
            new FileOutputStream(FILE));

    objectOutputStreamCheckedConsumer.accept(objectOutputStream);
  }
  
  @SneakyThrows
  @Contract(pure = true)
  final <T> T withObjectInputStrream(@NotNull CheckedFunction1<ObjectInputStream, T> oisCheckedConsumer) {
    @Cleanup val objectInputStream =
        new ObjectInputStream(
            new FileInputStream(FILE));

    return oisCheckedConsumer
        .apply(objectInputStream);
  }


  
  @Test
  @SneakyThrows
  @DisplayName("\"Name\" method works correctly")
  void testName() {
    // given
    val line = new Line(new Point(1, 1),
        new Point(2, 2),
        1);

    // when
    withObjectOutputStrream(objectOutputStream ->
        objectOutputStream.writeObject(line));

    Object line2 = withObjectInputStrream(
        ObjectInputStream::readObject
//        ObjectInputStream.readObject(objectInputStream)
    );

    // then
    assertThat(((Line) line2).getPoint1().getX())
        .isEqualTo(1);

  }
}