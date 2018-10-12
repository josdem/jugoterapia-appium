package appium.jugoterapia.dem.jos.com.jugoterapia_appium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 2");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "9.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.jugoterapia.josdem");
        capabilities.setCapability("appActivity", "com.jugoterapia.josdem.activity.CategoryActivity");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void shouldSelectCurativos() throws Exception {
        System.out.println("Running shouldSelectSaludable at " + new Date());
        WebElement textView = driver.findElement(By.id("categoryTextView"));
        assertEquals("Curativos", textView.getText());
    }

    @After
    public void End(){
        driver.quit();
    }

}