package com.epam.automation.pageobjects.tempmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.automation.pageobjects.AbstractPage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TenMinuteMailPage extends AbstractPage {

    private final String BASE_URL = "https://10minutemail.com/";

    private final By COST_FIELD_LOCATOR = By.xpath("//h3[contains(.,'USD')]");

    @FindBy(xpath = "//div[@id='copy_address']")
    WebElement copyEmailButton;

    @FindBy(xpath = "//div[@class='mail_message']")
    WebElement messageContainer;

    @FindBy(xpath = "//input[@id='mail_address']")
    WebElement mailAddressField;

    public TenMinuteMailPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getEstimatedCostFromMessage() {
        waitForElementToBeClickable(messageContainer, 120).click();
        return waitForElementPresence(COST_FIELD_LOCATOR, 60).getText();
    }

    public String getEmailAddress() {
        waitForElementToBeClickable(mailAddressField, 10);
        waitForElementToBeClickable(copyEmailButton, 30).click();
        String email = null;
        try {
            email = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return email;
    }

    @Override
    public TenMinuteMailPage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened mail page");
        return this;
    }

    public TenMinuteMailPage switchTab(String tab) {
        webDriver.switchTo().window(tab);
        logger.info("Switched tab to " + tab);
        return this;
    }

    public TenMinuteMailPage openPage() {
        webDriver.get(BASE_URL);
        return this;
    }
}
