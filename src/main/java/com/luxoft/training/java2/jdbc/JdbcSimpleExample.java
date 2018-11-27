package com.luxoft.training.java2.jdbc;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.sql.DriverManager;

import static lombok.AccessLevel.PRIVATE;

@Value
@FieldNameConstants
class Student {
  Long id;
  String name;
  Integer groupId;
}

@UtilityClass
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class JdbcSimpleExample {

  String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

  //language=H2
  String CREATE_TABLE_SQL = "create table student (id identity, name varchar not null, groupId int)";//language=H2
  String INSERT_STUDENT_SQL = "insert into student (name, groupId) values ('Вася Пупкин', 123456)";//language=H2
  String GET_STUDENTS_SQL = "select id, name, groupId from student";

  @SneakyThrows
  public void main(String... __) {
    @Cleanup val connection = DriverManager.getConnection(DB_URL);
    @Cleanup val statement = connection.createStatement();
    statement.executeUpdate(CREATE_TABLE_SQL);
    statement.executeUpdate(INSERT_STUDENT_SQL);
    @Cleanup val resultSet = statement.executeQuery(GET_STUDENTS_SQL);
    while (resultSet.next())
      System.out.println(new Student(
          resultSet.getLong(Student.FIELD_ID),
          resultSet.getString(Student.FIELD_NAME),
          resultSet.getInt(Student.FIELD_GROUP_ID)));
  }
}
