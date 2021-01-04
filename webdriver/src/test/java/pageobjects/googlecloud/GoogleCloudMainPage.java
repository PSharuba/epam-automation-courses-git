package pageobjects.googlecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AbstractPage;

public class GoogleCloudMainPage extends AbstractPage {
    private final String SEARCH_FIELD_LOCATOR = "//input[@name='q']";
    private final String RESULT_BOX_LOCATOR = "//div[@class='gsc-expansionArea']";
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
        searchField = new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_FIELD_LOCATOR)));
        searchField.click();
        searchField.sendKeys(query);

        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_SUGGESTION_PREFIX + query.toLowerCase() + RESULT_SUGGESTION_POSTFIX
                ))).click();

        return this;
    }

    public GoogleCloudCalculatorPage chooseDesiredResult(String query) {
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(RESULT_BOX_LOCATOR)));

        getWebDriver().findElement(By.xpath(RESULT_PREFIX + query + RESULT_POSTFIX)).click();
        return new GoogleCloudCalculatorPage(getWebDriver());
    }

    @Override
    public GoogleCloudMainPage openPage(String URL) {
        getWebDriver().get(URL);
        return this;
    }
}
