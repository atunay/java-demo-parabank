package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import com.java_parabank_demo.Pages.BrowserFactory.BrowserFactory;
import com.java_parabank_demo.helpers.CredentialsAndURLS;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;

    private static String loginUrl;

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        CredentialsAndURLS credentialsAndURLS = new CredentialsAndURLS();
        try {
            credentialsAndURLS.credentialsAndURLS();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }


        loginUrl = credentialsAndURLS.getBaseURL(); //new
        System.out.println("baseURL: " + loginUrl);


        loginUrl = credentialsAndURLS.getBaseURL();
        String expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(loginUrl, expectedURL);

    }
}
