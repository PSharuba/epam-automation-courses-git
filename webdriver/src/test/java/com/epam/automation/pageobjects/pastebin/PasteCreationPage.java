package com.epam.automation.pageobjects.pastebin;

import com.epam.automation.model.Paste;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.automation.pageobjects.AbstractPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteCreationPage extends AbstractPage {
    private final String BASE_URL = "https://pastebin.com/";

    private final static String OPTION_LOCATOR_PREFIX = "//li[text()='";
    private final static String OPTION_LOCATOR_POSTFIX = "']";

    @FindBy(id = "postform-text")
    private WebElement pasteTextField;

    @FindBy(id = "postform-name")
    private WebElement pasteTitleField;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationField;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement pasteHighlightingField;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']")
    private WebElement pasteExpirationOptionsList;

    @FindBy(xpath = "//ul[@id='select2-postform-format-results']")
    private WebElement pasteHighlightingOptionsList;

    @FindBy(xpath = "//button[@type='submit'][text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public PasteCreationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public PasteCreationPage fillPasteFields(Paste paste) {
        logger.info("Started filling paste fields");
        if (paste.getHighlighting() != null) {
            setHighlighting(paste.getHighlighting());
        }
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(pasteExpirationField)).click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(OPTION_LOCATOR_PREFIX + paste.getExpiration() + OPTION_LOCATOR_POSTFIX)))
                .click();

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(pasteTextField)).sendKeys(paste.getText());
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(pasteTitleField)).sendKeys(paste.getTitle());

        logger.info("Filled paste fields");
        return this;
    }

    public PasteCreationPage setHighlighting(String highlighting) {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(pasteHighlightingField)).click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(OPTION_LOCATOR_PREFIX + highlighting + OPTION_LOCATOR_POSTFIX)))
                .click();
        return this;
    }

    public PastePage postPaste() {
        createNewPasteButton.click();
        logger.info("Posted paste");
        return new PastePage(webDriver);
    }

    @Override
    public PasteCreationPage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened PasteCreation page on " + URL);
        return this;
    }

    public PasteCreationPage openPage() {
        webDriver.get(BASE_URL);
        logger.info("Opened PasteCreation page");
        return this;
    }
}
