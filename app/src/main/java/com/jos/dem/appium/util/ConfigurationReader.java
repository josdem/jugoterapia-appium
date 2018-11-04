package com.jos.dem.appium.util;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigurationReader {
  private static Configurations configurations = new Configurations();
  private static File file = new File("src/main/res/configuration.properties");

  private static Logger log = Logger.getLogger(ConfigurationReader.class.getName());

  public static String getProperty(String key){
    String value = StringUtils.EMPTY;
    try{
      Configuration configuration = configurations.properties(file);
      value = configuration.getString(key);
    }catch(ConfigurationException cex){
      log.warning(cex.getMessage());
    }
    return value;
  }

}
