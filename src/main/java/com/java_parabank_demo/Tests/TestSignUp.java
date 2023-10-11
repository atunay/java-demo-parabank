package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Authorization.SignUpForm;
import com.java_parabank_demo.Pages.BrowserFactory.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class TestSignUp {
    WebDriver driver;
    SignUpForm ObjSignUp;
    @Before
    public void setUp() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

     @After
     public void quitDriver() {
         if (driver != null) {
             driver.quit();
             driver = null;
         }
     }
    @Test
    public void sampleTest10 () throws IOException, ParseException, org.json.simple.parser.ParseException {

       ObjSignUp = new SignUpForm(driver);
       ObjSignUp.signingUp();
       ObjSignUp.text();
    }
}
