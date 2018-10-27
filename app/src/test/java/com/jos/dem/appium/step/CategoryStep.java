package com.jos.dem.appium.step;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import com.jos.dem.appium.service.CategoryService;
import com.jos.dem.appium.service.impl.CategoryServiceImpl;

public class CategoryStep {

  private AppiumDriver<WebElement> driver;
  private WebElement textView;
  private DesiredCapabilities capabilities = new DesiredCapabilities();
  private CategoryService categoryService = new CategoryServiceImpl();

  private Logger log = Logger.getLogger(CategoryStep.class.getName());

  @Before
  public void setup(){
    categoryService.setCapabilities(capabilities);
  }

  @When("I launch the application")
  public void shouldLaunchTheApplication() throws Exception {
    log.info("Running: I launch the application at " + new Date());
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Then("I should be able to see the category list")
  public void shouldDisplayCategories() throws Exception {
    log.info("Running: I should be able to see the category list at " + new Date());
    assumeTrue(driver.findElement(By.id("listViewCategories")) != null);
    textView = driver.findElement(By.id("categoryTextView"));
    assertEquals("Curativos", textView.getText());
  }

  @And("I should be able to click in the category")
  public void shouldClickInCategory() throws Exception {
    log.info("Running: I should be able to click in the category at " + new Date());
    textView.click();
  }

  @After
  public void end(){
    driver.quit();
  }

}

