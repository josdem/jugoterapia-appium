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
    capabilities.setCapability("app", ConfigurationReader.getProperty("application.app"));
    capabilities.setCapability("testobjectApiKey", ConfigurationReader.getProperty("soucelab.key"));
    capabilities.setCapability("testobject_app_id", ConfigurationReader.getProperty("soucelab.id"));
  }

  public DesiredCapabilities getCapabilities(){
    return capabilities;
  }

}
