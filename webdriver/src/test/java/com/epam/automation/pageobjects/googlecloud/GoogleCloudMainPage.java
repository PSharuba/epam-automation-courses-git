package com.epam.automation.pageobjects.googlecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.automation.pageobjects.AbstractPage;

public class GoogleCloudMainPage extends AbstractPage {
    private final String BASE_URL = "https://cloud.google.com/";

    private final By RESULT_BOX_LOCATOR = By.xpath("//div[@class='gsc-expansionArea']");
    private final String RESULT_LOCATOR = "//a/b[text()='%s']";
    private final String RESULT_SUGGESTION_LOCATOR = "//b[contains(.,'%s')]";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public GoogleCloudMainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudMainPage enterSearchQuery(String query) {
        waitForElementToBeClickable(searchField, 10)
                .click();
        searchField.sendKeys(query);

        waitForElementPresence(String.format(RESULT_SUGGESTION_LOCATOR, query.toLowerCase()), 10)
                .click();
        logger.info("Entered search query");
        return this;
    }

    public GoogleCloudCalculatorPage chooseDesiredResult(String query) {
        waitForElementPresence(RESULT_BOX_LOCATOR, 10);

        webDriver.findElement(By.xpath(String.format(RESULT_LOCATOR, query))).click();

        logger.info("Chosen search result");
        return new GoogleCloudCalculatorPage(webDriver);
    }

    @Override
    public GoogleCloudMainPage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened google cloud main page on " + URL);
        return this;
    }

    public GoogleCloudMainPage openPage() {
        webDriver.get(BASE_URL);
        logger.info("Opened google cloud main page");
        return this;
    }
}
