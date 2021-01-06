package com.epam.automation.pageobjects.tempmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        new WebDriverWait(webDriver, 120)
                .until(ExpectedConditions.elementToBeClickable(messageContainer)).click();

        return new WebDriverWait(webDriver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(COST_FIELD_LOCATOR))
                .getText();
    }

    public String getEmailAddress() {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mailAddressField));
        new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.elementToBeClickable(copyEmailButton))
                .click();
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
