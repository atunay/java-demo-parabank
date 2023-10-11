package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import com.java_parabank_demo.Pages.BrowserFactory.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Test_Log_In {
    WebDriver driver;
    Log_In_Form ObjLogInForm;
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
    public void testWithCorrectCredentials () throws IOException, ParseException, org.json.simple.parser.ParseException {
        ObjLogInForm = new Log_In_Form(driver);
        ObjLogInForm.fillCredentials();
    }
    @Test
    public void testWithWrongCredentials () throws IOException, ParseException, org.json.simple.parser.ParseException {
        ObjLogInForm = new Log_In_Form(driver);
        ObjLogInForm.fillCredentials();
        ObjLogInForm.warningTxt();
    }
    @Test
    public void testWithoutAnyCredentials () throws IOException, ParseException, org.json.simple.parser.ParseException {
        ObjLogInForm = new Log_In_Form(driver);
        ObjLogInForm.fillCredentials();
        ObjLogInForm.warningTxt2();
    }
    @Test
    public void testWithCredentials2 () throws IOException, ParseException, org.json.simple.parser.ParseException {
        ObjLogInForm = new Log_In_Form(driver);
        ObjLogInForm.fillCredentials();
        ObjLogInForm.warningTxt3();
    }
}
