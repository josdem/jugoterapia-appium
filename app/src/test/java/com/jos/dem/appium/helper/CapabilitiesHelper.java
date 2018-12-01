package com.jos.dem.appium.helper;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.jos.dem.appium.util.ConfigurationReader;

public class CapabilitiesHelper {

  private  DesiredCapabilities capabilities = new DesiredCapabilities();

  public CapabilitiesHelper(){
    capabilities.setCapability("deviceName", ConfigurationReader.getProperty("device.name"));
    capabilities.setCapability("platformName", ConfigurationReader.getProperty("device.platform"));
    capabilities.setCapability("platformVersion", ConfigurationReader.getProperty("device.version"));
    capabilities.setCapability("appPackage", ConfigurationReader.getProperty("application.package"));
    capabilities.setCapability("appActivity", ConfigurationReader.getProperty("application.activity"));
  }

  public DesiredCapabilities getCapabilities(){
    return capabilities;
  }

}
