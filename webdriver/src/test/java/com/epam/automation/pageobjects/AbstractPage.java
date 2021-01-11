package com.epam.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected Logger logger;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = LogManager.getRootLogger();
        logger.info("Created page object");
    }


    public abstract AbstractPage openPage(String URL);

    public static ArrayList<String> openNewTab(WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        return new ArrayList<>(webDriver.getWindowHandles());
    }

    public static void switchTab(String tab, WebDriver webDriver) {
        webDriver.switchTo().window(tab);
    }

    protected WebElement waitForElementToBeClickable(String locator, int timeout) {
        return new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected WebElement waitForElementToBeClickable(By locator, int timeout) {
        return new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeClickable(WebElement element, int timeout) {
        return new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForElementPresence(String locator, int timeout) {
        return new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected WebElement waitForElementPresence(By locator, int timeout) {
        return new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
