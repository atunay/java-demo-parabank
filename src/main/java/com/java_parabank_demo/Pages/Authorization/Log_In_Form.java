package com.java_parabank_demo.Pages.Authorization;

import com.java_parabank_demo.helpers.CredentialsAndURLS;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Objects;

public class Log_In_Form {
    protected WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginPanel\"]/form/div[1]/input")
    @CacheLookup
    WebElement name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"loginPanel\"]/form/div[2]/input")
    @CacheLookup
    WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    @CacheLookup
    WebElement enter;
    @FindBy(how = How.XPATH, using = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    @CacheLookup
    WebElement logout;
    @FindBy(how = How.XPATH, using = "//*[@id=\"rightPanel\"]/div/div/h1")
    @CacheLookup
    WebElement text;


    public Log_In_Form(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCredentials() throws IOException, ParseException, org.json.simple.parser.ParseException {

        CredentialsAndURLS credentialsAndURLSObj = new CredentialsAndURLS();
        credentialsAndURLSObj.credentialsAndURLS();

        String loginUrl = credentialsAndURLSObj.getBaseURL();
        driver.get(loginUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(name));
        String username = credentialsAndURLSObj.getUsername();//new
        name.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(password));
        String pass = credentialsAndURLSObj.getPassword();//new
        password.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(enter));
        enter.click();
       // wait.until(ExpectedConditions.visibilityOf(enter));
        //logout.click();

        System.out.println("username: " + username);
        System.out.println("password: " + pass);
        System.out.println("baseURL: " + loginUrl);
        //System.out.println("The Test is passed!");
    }

    public void warningTxt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(text));
        String actualWarningTxt = text.getText();
        String expectedWarningTxt = ("The username and password could not be verified.");
        //String expectedWarningTxt2 = ("Please enter a username and password.");
        //String actualWarningTxt = text.getText();
        System.out.println(actualWarningTxt);
        Assert.assertEquals(expectedWarningTxt, actualWarningTxt);

        if (Objects.equals(expectedWarningTxt, actualWarningTxt)) {
            System.out.println("Wrong credentials!");
        }

    }

    public void warningTxt2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(text));
        String actualWarningTxt = text.getText();
        String expectedWarningTxt = ("Please enter a username and password.");
        System.out.println(actualWarningTxt);
        Assert.assertEquals(expectedWarningTxt, actualWarningTxt);
        if (Objects.equals(expectedWarningTxt, actualWarningTxt)) {
            System.out.println("There is no any credentials");
        }
    }

    public void warningTxt3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(text));
        String actualWarningTxt = text.getText();
        String expectedWarningTxt = ("Accounts Overview");
        System.out.println(actualWarningTxt);
        Assert.assertEquals(expectedWarningTxt, actualWarningTxt);
        if (Objects.equals(expectedWarningTxt, actualWarningTxt)) {
            System.out.println("NICE TO SEE YOU AGAIN!");
        }
    }
}

