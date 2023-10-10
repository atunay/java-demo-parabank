package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class Bill_Pay_Form extends Log_In_Form {
    @FindBy(how = How.LINK_TEXT, using = "Bill Pay")
    @CacheLookup
    WebElement billPayButton;
    @FindBy(how = How.NAME, using = "payee.name")
    @CacheLookup
    WebElement payeeNameFieldLocator;
    @FindBy(how = How.NAME, using = "payee.address.street")
    @CacheLookup
    WebElement addressFieldLocator;
    @FindBy(how = How.NAME, using = "payee.address.city")
    @CacheLookup
    WebElement cityFieldLocator;
    @FindBy(how = How.NAME, using = "payee.address.state")
    @CacheLookup
    WebElement stateFieldLocator;
    @FindBy(how = How.NAME, using = "payee.address.zipCode")
    @CacheLookup
    WebElement zipCodeFieldLocator;
    @FindBy(how = How.NAME, using = "payee.phoneNumber")
    @CacheLookup
    WebElement phoneFieldLocator;
    @FindBy(how = How.NAME, using = "payee.accountNumber")
    @CacheLookup
    WebElement accountFieldLocator;
    @FindBy(how = How.NAME, using = "verifyAccount")
    @CacheLookup
    WebElement verifyAccountFieldLocator;
    @FindBy(how = How.NAME, using = "amount")
    @CacheLookup
    WebElement amountFieldLocator;
    @FindBy(how = How.NAME, using = "fromAccountId")
    @CacheLookup
    WebElement fromAccountDropMenuLocator;
    @FindBy(how = How.XPATH, using = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input")
    @CacheLookup
    WebElement sendPaymentSubmitButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"rightPanel\"]/p")
    @CacheLookup
    WebElement welcomeText;

    public Bill_Pay_Form (WebDriver driver) {
        super(driver);
    }

    public void checkBillPayForm () throws IOException, ParseException, org.json.simple.parser.ParseException {

        fillCredentials();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(billPayButton));
        billPayButton.click();
        wait.until(ExpectedConditions.visibilityOf(payeeNameFieldLocator));
        payeeNameFieldLocator.sendKeys("CEZ");
        wait.until(ExpectedConditions.visibilityOf(addressFieldLocator));
        addressFieldLocator.sendKeys("Lenin blv. 10");
        wait.until(ExpectedConditions.visibilityOf(cityFieldLocator));
        cityFieldLocator.sendKeys("NY");
        wait.until(ExpectedConditions.visibilityOf(stateFieldLocator));
        stateFieldLocator.sendKeys("NY");
        wait.until(ExpectedConditions.visibilityOf(zipCodeFieldLocator));
        zipCodeFieldLocator.sendKeys("11703");
        wait.until(ExpectedConditions.visibilityOf(phoneFieldLocator));
        phoneFieldLocator.sendKeys("5166348805");
        wait.until(ExpectedConditions.visibilityOf(accountFieldLocator));
        accountFieldLocator.sendKeys("595959");
        wait.until(ExpectedConditions.visibilityOf(verifyAccountFieldLocator));
        verifyAccountFieldLocator.sendKeys("595959");
        wait.until(ExpectedConditions.visibilityOf(amountFieldLocator));
        amountFieldLocator.sendKeys("500");

        wait.until(ExpectedConditions.visibilityOf(fromAccountDropMenuLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromAccountDropMenuLocator).click().build().perform();
        //fromAccountDropMenuLocator.click();


        wait.until(ExpectedConditions.visibilityOf(sendPaymentSubmitButton));
        sendPaymentSubmitButton.click();

    }
}
