package com.java_parabank_demo.Tests;

import com.java_parabank_demo.helpers.CredentialsAndURLS;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class TestsValidURL {
    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        try {
            CredentialsAndURLS.credentialsAndURLS();
        } catch (IOException | ParseException | org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
        String loginUrl = CredentialsAndURLS.getBaseURL(); //new
        System.out.println("baseURL: " + loginUrl);
        String expectedURL = "https://parabank.parasoft.com/";
        Assert.assertEquals(expectedURL, loginUrl);
    }
}
