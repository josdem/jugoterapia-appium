package com.jos.dem.appium.util;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigurationReader {
  private static Configurations configurations = new Configurations();
  private static File file = new File("src/main/res/configuration.properties");

  public static String getProperty(String key) throws ConfigurationException {
    Configuration configuration = configurations.properties(file);
    return configuration.getString(key);
  }

}
