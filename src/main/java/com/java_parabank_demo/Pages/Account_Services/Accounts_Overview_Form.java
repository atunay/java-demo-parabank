package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class Accounts_Overview_Form extends Log_In_Form {

    @FindBy(how = How.XPATH, using = "//*[@id=\"leftPanel\"]/ul/li[2]/a")
    @CacheLookup
    WebElement accountsOverviewButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")//*[@id="accountId"]
    @CacheLookup
    WebElement accountNum;
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountId\"]")
    @CacheLookup
    WebElement accountID;
    @FindBy(how = How.ID, using = "accountType")
    @CacheLookup
    WebElement accountType;
    @FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
    @CacheLookup
    WebElement accountBalance;
    @FindBy(how = How.XPATH, using = "//*[@id=\"availableBalance\"]")//*[@id="availableBalance"]
    @CacheLookup
    WebElement availableBalance;
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountTable\"]/tbody/tr[2]/td[2]/b")
    @CacheLookup
    WebElement total;
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[2]")//*[@id="accountTable"]/tbody/tr[1]/td[3]
    @CacheLookup
    WebElement availableAmount;
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountTable\"]/tfoot/tr/td")
    @CacheLookup
    WebElement note;

    public Accounts_Overview_Form(WebDriver driver) {
        super(driver);
    }
    public void checkAccountDetails() throws IOException, ParseException, org.json.simple.parser.ParseException {

        fillCredentials();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(accountsOverviewButton));
        accountsOverviewButton.click();
        wait.until(ExpectedConditions.visibilityOf(availableAmount));
        String ActualValue = availableAmount.getText();
        /*wait.until(ExpectedConditions.visibilityOf(total));
        String ExpectedValue = total.getText();*/
        //Assert.assertEquals(ExpectedValue, ActualValue);
        wait.until(ExpectedConditions.visibilityOf(availableAmount));
        wait.until(ExpectedConditions.visibilityOf(note));
        String actualNote = note.getText();
        String expectedNote = ("*Balance includes deposits that may be subject to holds");
        Assert.assertEquals(expectedNote, actualNote);
        wait.until(ExpectedConditions.visibilityOf(accountNum));
        accountNum.click();
        wait.until(ExpectedConditions.visibilityOf(accountID));
        accountID.getText();
        wait.until(ExpectedConditions.visibilityOf(accountType));
        accountType.getText();
        wait.until(ExpectedConditions.visibilityOf(accountBalance));
        accountBalance.getText();
        wait.until(ExpectedConditions.visibilityOf(availableBalance));
        accountBalance.getText();
    }
}
