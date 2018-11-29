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

    File parentFile = file.getParentFile();
    if (!parentFile.exists() && !parentFile.mkdir())
      throw new RuntimeException("Не удалось создать папку для файла! " + parentFile);

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

    File parentFile = file.getParentFile();
    if (parentFile.list().length == 0 && !parentFile.delete())
      throw new RuntimeException(
          String.format("Не удалось удалить папку %s, содержавшую файл %s",
              parentFile,
              file));

    return file;
  }

  public void deleteFile(String filePath) {
    deleteFile(new File(filePath));
  }

}
