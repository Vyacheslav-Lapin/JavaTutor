package com.luxoft.training.java2.module2;

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.File;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class FileTutor {

  /**
   * Метод должен создавать папку test и в ней - файл test/test.txt
   * Также выведите в лог полный путь к созданному файлу
   */
  @SneakyThrows
  public File createFile(String filePath) {
    File file = new File(filePath);
    if (!file.createNewFile())
      throw new RuntimeException("Не хватает прав для создания файла "
          + file.getAbsolutePath());
    return file;
  }

  /**
   * Метод должен удалять папку test и файл test/test.txt
   */
  public File deleteFile(File file) {
    if (!file.delete())
      throw new RuntimeException("Не хватает прав для удаления файла " + file);
    return file;
  }

  public void deleteFile(String filePath) {
    deleteFile(new File(filePath));
  }

}
