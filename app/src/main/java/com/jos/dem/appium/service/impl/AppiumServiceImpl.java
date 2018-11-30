package com.jos.dem.appium.service.impl;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.appium.service.AppiumService;
import com.jos.dem.appium.util.ConfigurationReader;

public class AppiumServiceImpl implements AppiumService {

  public void setCapabilities(DesiredCapabilities capabilities){
    capabilities.setCapability("deviceName", ConfigurationReader.getProperty("device.name"));
    capabilities.setCapability("platformName", ConfigurationReader.getProperty("device.platform"));
    capabilities.setCapability("platformVersion", ConfigurationReader.getProperty("device.version"));
    capabilities.setCapability("appPackage", ConfigurationReader.getProperty("application.package"));
    capabilities.setCapability("appActivity", ConfigurationReader.getProperty("application.activity"));
  }

}
