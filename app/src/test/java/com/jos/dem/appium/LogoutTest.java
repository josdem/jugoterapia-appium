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

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Date;
import java.util.logging.Logger;

import org.openqa.selenium.By;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LogoutTest extends BaseTest {

  private AndroidDriver<AndroidElement> driver;

  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I am in the main screen")
  public void shouldBeInMainScreen() throws Exception {
    log.info("Running: I am in the main screen at " + new Date());
    assumeTrue(driver.findElement(By.id("listViewCategories")) != null);
    driver = getDriver();
  }

  @Then("I verify driver is stopped")
  public void shouldVerifyDriverIsStopped() throws Exception {
    log.info("Running: I am in the main screen at " + new Date());
    stopDriver();
  }

}
