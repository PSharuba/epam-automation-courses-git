package com.epam.automation.pageobjects.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.automation.pageobjects.AbstractPage;

public class PastePage extends AbstractPage {

    private final By PASTE_TEXT_AREA_LOCATOR = By.xpath("//div[@class='post-view']/textarea[@class='textarea']");
    private final By PASTE_HIGHLIGHTED_AREA_LOCATOR = By.xpath("//div[@class='highlighted-code']//a");
    private final By PASTE_TITLE_LOCATOR = By.xpath("//div[@class='info-top']/h1");

    public PastePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPasteText() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(PASTE_TEXT_AREA_LOCATOR)).getText();
    }

    public String getPasteTitle() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(PASTE_TITLE_LOCATOR)).getText();
    }

    public String getPasteHighlighting() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(PASTE_HIGHLIGHTED_AREA_LOCATOR)).getText();
    }

    @Override
    public PastePage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened paste page on " + URL);
        return this;
    }
}
