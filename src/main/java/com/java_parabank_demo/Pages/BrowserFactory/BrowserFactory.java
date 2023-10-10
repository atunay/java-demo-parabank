package com.java_parabank_demo.Pages.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserFactory {
    public static WebDriver driver;
    public static WebDriver getDriver(String browserName) {

        if (driver == null) {
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "/home/tunay/Documents/Dependencies/chromedriver-linux64/chromedriver");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);

            } else if (browserName.equalsIgnoreCase("Edge")) {
                //System.setProperty("webdriver.edge.driver", "/home/tunay/Documents/Dependencies/edgedriver_linux64/msedgedriver");

                EdgeOptions options = new EdgeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(options);
            }
        }
        return driver;
    }
}
