package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Account_Services.Transfer_Funds_Form;
import com.java_parabank_demo.Pages.BrowserFactory.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class TestTransferFundsForm {
    WebDriver driver;
    Transfer_Funds_Form ObjTransfer_Funds_Form;
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
    public void TestTransferFunds () throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        ObjTransfer_Funds_Form = new Transfer_Funds_Form(driver);
        ObjTransfer_Funds_Form.checkTransferFunds();
    }
}
