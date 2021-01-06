package com.epam.automation.tests;

import com.epam.automation.driver.DriverSingleton;
import com.epam.automation.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver webDriver;
    protected Logger log = LogManager.getRootLogger();

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = DriverSingleton.getDriver();
        log.info("Got driver");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverSingleton.closeDriver();
        webDriver = null;
        log.info("Closed driver");
    }
}
