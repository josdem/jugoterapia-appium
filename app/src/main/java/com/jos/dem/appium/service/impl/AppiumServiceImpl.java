package com.jos.dem.appium.service.impl;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.appium.util.ConfigurationReader;
import com.jos.dem.appium.service.AppiumService;

public class AppiumServiceImpl implements AppiumService {

  public void setCapabilities(DesiredCapabilities capabilities) throws IOException {
    capabilities.setCapability("deviceName", ConfigurationReader.getProperty("device.name"));
    capabilities.setCapability("platformName", ConfigurationReader.getProperty("device.platform"));
    capabilities.setCapability("platformVersion", ConfigurationReader.getProperty("device.version"));
    capabilities.setCapability("appPackage", ConfigurationReader.getProperty("application.package"));
    capabilities.setCapability("appActivity", ConfigurationReader.getProperty("application.activity"));
    capabilities.setCapability("app", ConfigurationReader.getProperty("application.app"));
    capabilities.setCapability("testobjectApiKey", ConfigurationReader.getProperty("soucelab.key"));
    capabilities.setCapability("testobject_app_id", ConfigurationReader.getProperty("soucelab.id"));
  }

}

