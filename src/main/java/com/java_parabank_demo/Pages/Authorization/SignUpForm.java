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

public class SignUpForm {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.firstName\"]")
    @CacheLookup
    WebElement firstName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.lastName\"]")
    @CacheLookup
    WebElement lastName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.address.street\"]")
    @CacheLookup
    WebElement address;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.address.city\"]")
    @CacheLookup
    WebElement city;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.address.state\"]")
    @CacheLookup
    WebElement state;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.address.zipCode\"]")
    @CacheLookup
    WebElement zipCode;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.phoneNumber\"]")
    @CacheLookup
    WebElement phoneNumber;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.ssn\"]")
    @CacheLookup
    WebElement ssn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.username\"]")
    @CacheLookup
    WebElement userName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer.password\"]")
    @CacheLookup
    WebElement password;
    @FindBy(how = How.ID, using = "repeatedPassword")
    @CacheLookup
    WebElement confirm;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    @CacheLookup
    WebElement register;
    @FindBy(how = How.XPATH, using = "//*[@id=\"rightPanel\"]/p")
    @CacheLookup
    WebElement welcomeText;


    public SignUpForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signingUp() throws IOException, ParseException, org.json.simple.parser.ParseException {

        CredentialsAndURLS credentialsAndURLS = new CredentialsAndURLS();
        credentialsAndURLS.credentialsAndURLS();

        String registerURL = credentialsAndURLS.getRegisterURL();
        driver.get(registerURL);

        String nameFirst = credentialsAndURLS.getFirstName();//new
        firstName.sendKeys(nameFirst);
        String nameLast = credentialsAndURLS.getLastName();//new
        lastName.sendKeys(nameLast);
        String strAddress = credentialsAndURLS.getAddress();//new
        address.sendKeys(strAddress);
        String cityAddress = credentialsAndURLS.getCity();//new
        city.sendKeys(cityAddress);
        String stateAddress = credentialsAndURLS.getState();//new
        state.sendKeys(stateAddress);
        String zip = credentialsAndURLS.getZipCode();//new
        zipCode.sendKeys(zip);
        String phnNumber = credentialsAndURLS.getPhone();//new
        phoneNumber.sendKeys(phnNumber);
        String userSSN = credentialsAndURLS.getSsn();//new
        ssn.sendKeys(userSSN);
        String username = credentialsAndURLS.getUsername();//new
        userName.sendKeys(username);
        String pass = credentialsAndURLS.getPassword();//new
        password.sendKeys(pass);
        String cnfrm = credentialsAndURLS.getConfirmPW();//new
        confirm.sendKeys(cnfrm);
        register.click();

        System.out.println("registerURL: " + registerURL);
        System.out.println("firstname: " + nameFirst);
        System.out.println("lastname: " + nameLast);
        System.out.println("address: " + strAddress);
        System.out.println("city: " + cityAddress);
        System.out.println("state: " + stateAddress);
        System.out.println("zipcode: " + zip);
        System.out.println("phonenumber: " + phnNumber);
        System.out.println("ssn: " + userSSN);
        System.out.println("username: " + username);
        System.out.println("password: " + pass);
        System.out.println("confirm: " + cnfrm);
    }
        public void text () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(welcomeText));
            String actualWarningTxt = welcomeText.getText();
            String expectedWarningTxt = ("Your account was created successfully. You are now logged in.");
            System.out.println(actualWarningTxt);
            Assert.assertEquals(expectedWarningTxt, actualWarningTxt);

            if (Objects.equals(expectedWarningTxt, actualWarningTxt)) System.out.println("WELCOME!");
        }
    }

