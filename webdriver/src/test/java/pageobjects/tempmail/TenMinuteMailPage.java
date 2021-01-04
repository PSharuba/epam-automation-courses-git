package pageobjects.tempmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AbstractPage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TenMinuteMailPage extends AbstractPage {
    private final String COST_FIELD_LOCATOR = "//h3[contains(.,'USD')]";

    @FindBy(xpath = "//div[@id='copy_address']")
    WebElement copyEmailButton;

    @FindBy(xpath = "//div[@class='mail_message']")
    WebElement messageContainer;

    public TenMinuteMailPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getEstimatedCostFromMessage() {
        new WebDriverWait(getWebDriver(), 60)
                .until(ExpectedConditions.elementToBeClickable(messageContainer)).click();

        return new WebDriverWait(getWebDriver(), 60)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COST_FIELD_LOCATOR)))
                .getText();
    }

    public String getEmailAddress() {
        new WebDriverWait(getWebDriver(), 10)
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
        getWebDriver().get(URL);
        return this;
    }

    public TenMinuteMailPage switchTab(String tab) {
        getWebDriver().switchTo().window(tab);
        return this;
    }
}
