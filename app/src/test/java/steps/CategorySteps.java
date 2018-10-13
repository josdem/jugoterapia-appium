package steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.AppiumDriver;

import static org.junit.Assert.assertEquals;

public class CategorySteps {

  AppiumDriver driver;
  DesiredCapabilities capabilities = new DesiredCapabilities();

  private void setup() throws MalformedURLException {
    capabilities.setCapability("deviceName", "Pixel 2");
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
    capabilities.setCapability(CapabilityType.VERSION, "9.0");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("appPackage", "com.jugoterapia.josdem");
    capabilities.setCapability("appActivity", "com.jugoterapia.josdem.activity.CategoryActivity");
  }

  @When("I launch the application")
  public void shouldOpenTheApplication() throws Exception {
    setup();
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Then("I should be able to see all categories")
  public void shouldDisplayCategories() throws Exception {
    System.out.println("Running shouldSelectSaludable at " + new Date());
    WebElement textView = driver.findElement(By.id("categoryTextView"));
    assertEquals("Curativos", textView.getText());
    end();
  }

  public void end(){
    driver.quit();
  }

}

