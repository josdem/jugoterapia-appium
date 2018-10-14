package com.jos.dem.appium.service.impl;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.appium.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

  private DesiredCapabilities capabilities = new DesiredCapabilities();

  public void CategoryServiceImpl(DesiredCapabilities capabilities){
    capabilities.setCapability("deviceName", "Pixel 2");
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
    capabilities.setCapability(CapabilityType.VERSION, "9.0");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("appPackage", "com.jugoterapia.josdem");
    capabilities.setCapability("appActivity", "com.jugoterapia.josdem.activity.CategoryActivity");
  }

  public DesiredCapabilities getCapabilities(){
    return capabilities;
  }

}
