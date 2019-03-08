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
    capabilities.setCapability("name", ConfigurationReader.getProperty("job.name"));
    capabilities.setCapability("build", ConfigurationReader.getProperty("job.build"));
    capabilities.setCapability("tag", ConfigurationReader.getProperty("job.tag"));
  }

}
