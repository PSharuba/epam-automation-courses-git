package com.epam.automation.tests;

import com.epam.automation.driver.DriverSingleton;
import com.epam.automation.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver webDriver;

    @BeforeMethod()
    public void browserSetup() {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverSingleton.closeDriver();
        webDriver = null;
    }
}
