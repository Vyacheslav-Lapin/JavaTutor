package com.luxoft.training.java2.module2;


import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;

import java.io.File;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FieldDefaults(level = PRIVATE)
class FileTutorTest { //for com.luxoft.training.java2.module2.FileTutor

  @SuppressWarnings("WeakerAccess")
  static final String FILE_PATH = "./test/test.txt";
  FileTutor fileTutor = new FileTutor();

  @Test
  void testDeleteFile() {

    // given, when
    File file = fileTutor.createFile(FILE_PATH);

    assertTrue(file.exists());

    // when
    fileTutor.deleteFile(file);

    // then
    assertFalse(file.exists());
  }
}