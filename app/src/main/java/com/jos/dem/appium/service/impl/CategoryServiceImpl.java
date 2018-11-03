package com.jos.dem.appium.service.impl;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.appium.service.CategoryService;
import com.jos.dem.appium.util.ConfigurationReader;

public class CategoryServiceImpl implements CategoryService {

  public void setCapabilities(DesiredCapabilities capabilities){
    capabilities.setCapability("deviceName", ConfigurationReader.getProperty("device.name"));
    capabilities.setCapability(CapabilityType.VERSION, "9");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("appPackage", "com.jugoterapia.josdem");
    capabilities.setCapability("appActivity", "com.jugoterapia.josdem.activity.CategoryActivity");
  }

}
