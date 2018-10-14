package com.jos.dem.appium.step;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.appium.java_client.AppiumDriver;

import com.jos.dem.appium.service.CategoryService;
import com.jos.dem.appium.service.impl.CategoryServiceImpl;

public class CategoryStep {

  @Inject
  private CategoryService categoryService;

  private AppiumDriver driver;
  private Logger log = Logger.getLogger(CategoryStep.class.getName());

  @When("I launch the application")
  public void shouldOpenTheApplication() throws Exception {
    log.info("Running: I launch the application at " + new Date());
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), categoryService.getCapabilities());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Then("I should be able to see all categories")
  public void shouldDisplayCategories() throws Exception {
    log.info("Running: I should be able to see all categories at " + new Date());
    WebElement textView = driver.findElement(By.id("categoryTextView"));
    assertEquals("Curativos", textView.getText());
  }

  @After
  public void end(){
    driver.quit();
  }

}

