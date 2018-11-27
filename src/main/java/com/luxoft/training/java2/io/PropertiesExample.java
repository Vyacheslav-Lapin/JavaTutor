package com.luxoft.training.java2.io;

import lombok.Cleanup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesExample {

  public static void main(String... __) throws IOException {

    var properties = new Properties();

    @Cleanup InputStream resourceAsStream = PropertiesExample.class
        .getResourceAsStream("/props.properties");

    properties.load(resourceAsStream);

    System.out.println(properties.getProperty("color")); // red
  }
}
