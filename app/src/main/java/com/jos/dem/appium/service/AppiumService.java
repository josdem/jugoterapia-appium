package com.jos.dem.appium.service;

import java.io.IOException;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface AppiumService {

  void setCapabilities(DesiredCapabilities capabilities) throws IOException;

}
