package com.jos.dem.appium.step;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.jos.dem.appium.util.ConfigurationReader;
import com.jos.dem.appium.service.AppiumService;
import com.jos.dem.appium.service.impl.AppiumServiceImpl;

public class BaseStep {

  private static AndroidDriver<AndroidElement> driver;
  private static DesiredCapabilities capabilities = new DesiredCapabilities();
  private static AppiumService appiumService = new AppiumServiceImpl();

  public static AndroidDriver<AndroidElement> getDriver() throws IOException {
    if(driver == null){
      appiumService.setCapabilities(capabilities);
      driver = new AndroidDriver(new URL(ConfigurationReader.getProperty("appium.server")), capabilities);
      driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationReader.getProperty("appium.wait")), TimeUnit.SECONDS);
    }
    return driver;
  }

}

