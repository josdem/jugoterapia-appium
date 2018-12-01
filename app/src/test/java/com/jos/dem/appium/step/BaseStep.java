package com.jos.dem.appium.step;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.jos.dem.appium.util.ConfigurationReader;
import com.jos.dem.appium.helper.CapabilitiesHelper;

public class BaseStep {

  private static AndroidDriver<AndroidElement> driver;
  private static CapabilitiesHelper helper = new CapabilitiesHelper();

  public static AndroidDriver<AndroidElement> getDriver() throws IOException {
    if(driver == null){
      driver = new AndroidDriver(new URL(ConfigurationReader.getProperty("appium.server")), helper.getCapabilities());
      driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationReader.getProperty("appium.wait")), TimeUnit.SECONDS);
    }
    return driver;
  }

  public static AndroidElement waitForElement(AndroidElement element){
    WebDriverWait wait =  new WebDriverWait(driver, Long.parseLong(ConfigurationReader.getProperty("appium.timeout")));
    wait.until(ExpectedConditions.visibilityOf(element));
    return element;
  }

  public static void stopDriver(){
    driver.quit();
  }

}

