package pageobjects.googlecloud;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AbstractPage;

import java.util.HashMap;
import java.util.List;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private final String OPTION_LOCATOR_PREFIX = "//md-option/div[contains(.,'";
    private final String OPTION_LOCATOR_POSTFIX = "')]/..";
    private final String MACHINE_CLASS_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_81']//div[contains(.,'";
    private final String MACHINE_SERIES_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_89']//div[contains(.,'";
    private final String MACHINE_TYPE_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_91']//div[contains(.,'";
    private final String GPU_NUMBER_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_395']//div[contains(.,'";
    private final String GPU_TYPE_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_397']//div[contains(.,'";
    private final String SSD_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_356']//div[contains(.,'";
    private final String DATA_CENTER_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_93']//div[contains(.,'";
    private final String COMMITED_USAGE_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_100']//div[contains(.,'";
    private final String RESULT_BLOCK_LOCATOR = "//md-card-content[@id='resultBlock']";
    private final String RESULT_LINES_LOCATOR = "//div[@class='md-list-item-text ng-binding']";
    private final String EMAIL_INPUT_LOCATOR = "//input[@type='email']";


    @FindBy(css = "md-pagination-wrapper > .md-tab:nth-child(1) .hexagon-in2")
    private WebElement computeEngineIcon;
    @FindBy(xpath = "//input[@id='input_63']")
    private WebElement instanceCountField;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_56']")
    private WebElement osField;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_57']")
    private WebElement machineClassField;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_59']")
    private WebElement machineSeriesField;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_60']")
    private WebElement machineTypeField;
    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement gpuCheckbox;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement gpuNumberField;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeField;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement ssdTypeField;
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement dataCenterLocationField;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageField;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    private WebElement resultInstanceCount;
    @FindBy(xpath = "//h2/b[@class='ng-binding']")
    private WebElement resultTotalCost;
    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//form[@name='emailForm']//button[contains(.,'Send Email')]")
    private WebElement sendEmailButton;

    public GoogleCloudCalculatorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudCalculatorPage selectComputeEngine() {
        getWebDriver().switchTo().frame(0);
        getWebDriver().switchTo().frame(0);
        computeEngineIcon.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterInstancesNumber(String number) {
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(instanceCountField))
                .sendKeys(number);
        return this;
    }

    public GoogleCloudCalculatorPage selectOS(String os) {

        osField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(OPTION_LOCATOR_PREFIX
                                + os
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage selectMachineClass(String machineClass) {
        machineClassField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(MACHINE_CLASS_OPTION_LOCATOR_PREFIX
                                + machineClass
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage selectMachineSeries(String series) {
        machineSeriesField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(MACHINE_SERIES_OPTION_LOCATOR_PREFIX
                                + series
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage selectMachineType(String type) {
        machineTypeField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(MACHINE_TYPE_OPTION_LOCATOR_PREFIX
                                + type
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage addGpuWithCertainType(String number, String type) {
        gpuCheckbox.click();
        gpuNumberField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(GPU_NUMBER_OPTION_LOCATOR_PREFIX
                                + number
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        gpuTypeField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(GPU_TYPE_OPTION_LOCATOR_PREFIX
                                + type
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage setSSD(String ssdType) {
        ssdTypeField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(SSD_OPTION_LOCATOR_PREFIX
                                + ssdType
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage setDataCenterLocation(String location) {
        dataCenterLocationField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(DATA_CENTER_OPTION_LOCATOR_PREFIX
                                + location
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage setCommitedUsage(String usage) {
        commitedUsageField.click();
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(COMMITED_USAGE_OPTION_LOCATOR_PREFIX
                                + usage
                                + OPTION_LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage addToEstimate() {
        addToEstimateButton.click();
        return this;
    }

    public HashMap<String, String> getResults() {
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(RESULT_BLOCK_LOCATOR)));
        HashMap<String, String> results = new HashMap<>();
        results.put("instance.number", resultInstanceCount.getText().charAt(0) + "");
        results.put("price", resultTotalCost.getText().replace("Total Estimated Cost: ", ""));
        List<WebElement> resultLines = getWebDriver().findElements(By.xpath(RESULT_LINES_LOCATOR));

        for (WebElement e : resultLines) {
            String text = e.getText();
            if (text.contains("VM class")) {
                results.put("vmClass", text.replace("VM class: ", ""));
                continue;
            }
            if (text.contains("Instance type")) {
                results.put("instance.type", text.replace("Instance type: ", ""));
                continue;
            }
            if (text.contains("Region")) {
                results.put("datacenter", text.replace("Region: ", ""));
                continue;
            }
            if (text.contains("SSD")) {
                results.put("ssd", text.replace("Total available local SSD space ", "").replace("i", ""));
                continue;
            }
            if (text.contains("Commitment term")) {
                results.put("usage", text.replace("Commitment term: ", ""));
            }
        }
        return results;
    }

    public String getEstimatedCost() {
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(RESULT_BLOCK_LOCATOR)));
        return resultTotalCost.getText()
                .replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    public GoogleCloudCalculatorPage sendEmail(String email) {
        getWebDriver().switchTo().frame(0);
        getWebDriver().switchTo().frame(0);
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();

        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_INPUT_LOCATOR)));
        emailField.sendKeys(email);


        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        return this;
    }

    @Override
    public GoogleCloudCalculatorPage openPage(String URL) {
        getWebDriver().get(URL);
        return this;
    }
}
