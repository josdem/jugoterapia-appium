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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.logging.Logger;

import org.openqa.selenium.By;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EasterEggTest extends BaseTest {

  private AndroidElement actionBar;
  private AndroidDriver<AndroidElement> driver;

  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I click on Jugoterapia header \"([^\"]*)\" times")
  public void shouldClickOnHeaderFiveTimes(Integer times) throws Exception {
    log.info("Running: I click on Jugoterapia header at " + new Date());
    driver = getDriver();
    actionBar = driver.findElement(By.id("action_bar"));
    waitForElement(actionBar).click();
    waitForElement(actionBar).click();
    waitForElement(actionBar).click();
    waitForElement(actionBar).click();
    waitForElement(actionBar).click();
  }

  @Then("I validate I can see hello world message")
  public void shouldValidateGetHelloWorldMessage() throws Exception {
    log.info("Running: I validate I can see hello world message at " + new Date());
    AndroidElement dialogButton = driver.findElement(By.id("button1"));
    waitForElement(dialogButton).click();
  }

}

