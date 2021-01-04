package pageobjects.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AbstractPage;

public class PastePage extends AbstractPage {
    private final String PASTE_TEXT_AREA_LOCATOR = "//div[@class='post-view']/textarea[@class='textarea']";
    private final String PASTE_HIGHLIGHTED_AREA_LOCATOR = "//div[@class='highlighted-code']//a";

    private WebElement pasteTextArea;
    private WebElement highlightedText;

    public PastePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPasteText() {
        pasteTextArea = new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(PASTE_TEXT_AREA_LOCATOR)));
        return pasteTextArea.getText();
    }

    public String getPasteHighlighting() {
        highlightedText = new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(PASTE_HIGHLIGHTED_AREA_LOCATOR)));
        return highlightedText.getText();
    }

    @Override
    public PastePage openPage(String URL) {
        getWebDriver().get(URL);
        return this;
    }
}
