package com.jos.dem.appium.service.impl;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.appium.service.CategoryService;
import com.jos.dem.appium.util.ConfigurationReader;

public class CategoryServiceImpl implements CategoryService {

  public void setCapabilities(DesiredCapabilities capabilities){
    capabilities.setCapability("deviceName", ConfigurationReader.getProperty("device.name"));
    capabilities.setCapability(CapabilityType.VERSION, ConfigurationReader.getProperty("device.version"));
    capabilities.setCapability("platformName", ConfigurationReader.getProperty("device.platform"));
    capabilities.setCapability("appPackage", ConfigurationReader.getProperty("application.package"));
    capabilities.setCapability("appActivity", ConfigurationReader.getProperty("application.activity"));
  }

}
