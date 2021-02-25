package com.epam.automation.pageobjects.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.epam.automation.pageobjects.AbstractPage;

public class PastePage extends AbstractPage {

    private final By PASTE_TEXT_AREA_LOCATOR = By.xpath("//div[@class='post-view']/textarea[@class='textarea']");
    private final By PASTE_HIGHLIGHTED_AREA_LOCATOR = By.xpath("//div[@class='highlighted-code']//a");
    private final By PASTE_TITLE_LOCATOR = By.xpath("//div[@class='info-top']/h1");

    public PastePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPasteText() {
        return waitForElementPresence(PASTE_TEXT_AREA_LOCATOR, 10).getText();
    }

    public String getPasteTitle() {
        return waitForElementPresence(PASTE_TITLE_LOCATOR, 10).getText();
    }

    public String getPasteHighlighting() {
        return waitForElementPresence(PASTE_HIGHLIGHTED_AREA_LOCATOR, 10).getText();
    }

    @Override
    public PastePage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened paste page on " + URL);
        return this;
    }
}
