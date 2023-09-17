package com.java_parabank_demo.Pages;

import com.java_parabank_demo.helpers.CredentialsAndURLS;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static java.nio.file.Paths.get;

public class LoadTheWebsite {
 String website = CredentialsAndURLS.getBaseURL();
  public void LoadTheWebsite (WebDriver driver) {
    driver.get(website);
    driver.manage().window().maximize();
  }
}
