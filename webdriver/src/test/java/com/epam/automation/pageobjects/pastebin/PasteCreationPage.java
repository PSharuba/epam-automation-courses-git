package com.epam.automation.pageobjects.pastebin;

import com.epam.automation.model.Paste;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.automation.pageobjects.AbstractPage;

public class PasteCreationPage extends AbstractPage {
    private final String BASE_URL = "https://pastebin.com/";

    private final static String OPTION_LOCATOR = "//li[text()='%s']";

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
        waitForElementToBeClickable(pasteExpirationField, 10).click();
        waitForElementPresence(String.format(OPTION_LOCATOR, paste.getExpiration()), 10)
                .click();

        waitForElementToBeClickable(pasteTextField, 10).sendKeys(paste.getText());
        waitForElementToBeClickable(pasteTitleField, 10).sendKeys(paste.getTitle());

        logger.info("Filled paste fields");
        return this;
    }

    public PasteCreationPage setHighlighting(String highlighting) {
        waitForElementToBeClickable(pasteHighlightingField, 10).click();
        waitForElementToBeClickable(String.format(OPTION_LOCATOR, highlighting), 10).click();
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
