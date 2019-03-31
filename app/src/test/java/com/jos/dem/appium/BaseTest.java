/*
  Copyright 2019 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.appium.step;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.jos.dem.appium.service.AppiumService;
import com.jos.dem.appium.service.impl.AppiumServiceImpl;
import com.jos.dem.appium.util.ConfigurationReader;

public class BaseTest {

  private static AndroidDriver<AndroidElement> driver;
  private static AppiumService appiumService = new AppiumServiceImpl();
  private static DesiredCapabilities capabilities = new DesiredCapabilities();

  public static AndroidDriver<AndroidElement> getDriver() throws IOException {
    if(driver == null){
      appiumService.setCapabilities(capabilities);
      driver = new AndroidDriver(new URL(ConfigurationReader.getProperty("appium.server")), capabilities);
      driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationReader.getProperty("appium.wait")), TimeUnit.SECONDS);
    }
    return driver;
  }

  public static AndroidElement waitForElement(AndroidElement element){
    WebDriverWait wait =  new WebDriverWait(driver, Long.parseLong(ConfigurationReader.getProperty("appium.timeout")));
    wait.until(ExpectedConditions.visibilityOf(element));
    return element;
  }

  public void stopDriver(){
    driver.quit();
  }

  public void restartApplication(){
    driver.closeApp();
    driver.launchApp();
  }


}

