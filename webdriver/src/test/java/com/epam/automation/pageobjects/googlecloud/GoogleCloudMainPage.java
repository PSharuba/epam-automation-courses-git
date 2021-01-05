package com.epam.automation.pageobjects.googlecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.automation.pageobjects.AbstractPage;

public class GoogleCloudMainPage extends AbstractPage {
    private final String BASE_URL = "https://cloud.google.com/";

    private final By SEARCH_FIELD_LOCATOR = By.xpath("//input[@name='q']");
    private final By RESULT_BOX_LOCATOR = By.xpath("//div[@class='gsc-expansionArea']");
    private final String RESULT_PREFIX = "//a/b[text()='";
    private final String RESULT_POSTFIX = "']";
    private final String RESULT_SUGGESTION_PREFIX = "//b[contains(.,'";
    private final String RESULT_SUGGESTION_POSTFIX = "')]";

    private WebElement searchField;

    public GoogleCloudMainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudMainPage enterSearchQuery(String query) {
        searchField = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(SEARCH_FIELD_LOCATOR));
        searchField.click();
        searchField.sendKeys(query);

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_SUGGESTION_PREFIX + query.toLowerCase() + RESULT_SUGGESTION_POSTFIX
                ))).click();
        logger.info("Entered search query");
        return this;
    }

    public GoogleCloudCalculatorPage chooseDesiredResult(String query) {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(RESULT_BOX_LOCATOR));

        webDriver.findElement(By.xpath(RESULT_PREFIX + query + RESULT_POSTFIX)).click();

        logger.info("Chosen search result");
        return new GoogleCloudCalculatorPage(webDriver);
    }

    @Override
    public GoogleCloudMainPage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened google cloud main page on "+URL);
        return this;
    }

    public GoogleCloudMainPage openPage() {
        webDriver.get(BASE_URL);
        logger.info("Opened google cloud main page");
        return this;
    }
}
