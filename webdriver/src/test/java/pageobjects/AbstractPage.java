package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public abstract class AbstractPage {
    private WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public abstract AbstractPage openPage(String URL);

    public static ArrayList<String> openNewTab(WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        return new ArrayList<>(webDriver.getWindowHandles());
    }

    public static void switchTab(String tab, WebDriver webDriver) {
        webDriver.switchTo().window(tab);
    }
}
