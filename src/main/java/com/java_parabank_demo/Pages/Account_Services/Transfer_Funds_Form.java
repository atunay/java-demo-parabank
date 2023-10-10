package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
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

public class Transfer_Funds_Form extends Log_In_Form {

    @FindBy(how = How.XPATH, using = "//*[@id=\"leftPanel\"]/ul/li[3]/a")
    @CacheLookup
    WebElement transferFundLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"amount\"]")
    @CacheLookup
    WebElement amountField;
    @FindBy(how = How.ID, using = "fromAccountId")
    @CacheLookup
    WebElement fromAccountId;
    @FindBy(how = How.ID, using = "toAccountId")
    @CacheLookup
    WebElement toAccountId;
    @FindBy(how = How.XPATH, using = "//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")
    @CacheLookup
    WebElement submitTransfer;

    public Transfer_Funds_Form (WebDriver driver) {
        super(driver);
    }
    public void checkTransferFunds () throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {

        fillCredentials();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(transferFundLink));
        transferFundLink.click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(amountField));
        amountField.sendKeys("150");

        wait.until(ExpectedConditions.elementToBeClickable(fromAccountId));
        fromAccountId.click();

        wait.until(ExpectedConditions.elementToBeClickable(toAccountId));
        toAccountId.click();

        wait.until(ExpectedConditions.visibilityOf(submitTransfer));
        //Thread.sleep(1500);
        submitTransfer.click();

    }
}
