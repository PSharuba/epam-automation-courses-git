package pageobjects.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.AbstractPage;

public class PasteCreationPage extends AbstractPage {

    @FindBy(id = "postform-text")
    private WebElement pasteTextField;

    @FindBy(id = "postform-name")
    private WebElement pasteNameField;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationField;

    @FindBy(id = "id=\"select2-postform-format-container\"")
    private WebElement pasteHighlightingField;

    @FindBy(id = "select2-postform-expiration-results")
    private WebElement pasteExpirationOptionsList;

    @FindBy(id = "id=\"select2-postform-format-results\"")
    private WebElement pasteHighlightingOptionsList;

    @FindBy(xpath = "//button[@type='submit'][text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public PasteCreationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public PasteCreationPage writePasteText(String text) {
        pasteTextField.sendKeys(text);
        return this;
    }

    public PasteCreationPage setPasteTitle(String title) {
        pasteNameField.sendKeys(title);
        return this;
    }

    public PasteCreationPage setExpiration(String expiration) {
        pasteExpirationField.click();
        pasteExpirationOptionsList.findElement(By.xpath("//li[text()='" + expiration + "']")).click();
        return this;
    }

    public PasteCreationPage setHighlighting(String highlighting) {
        pasteHighlightingField.click();
        pasteHighlightingOptionsList.findElement(By.xpath("//li[text()='" + highlighting + "']")).click();
        return this;
    }

    public PastePage postPaste() {
        createNewPasteButton.click();
        return new PastePage(getWebDriver());
    }

    @Override
    public PasteCreationPage openPage(String URL) {
        getWebDriver().get(URL);
        return this;
    }
}
