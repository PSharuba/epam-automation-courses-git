package com.epam.automation.pageobjects.googlecloud;

import com.epam.automation.model.GoogleCloudComputerInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.automation.pageobjects.AbstractPage;

import java.util.HashMap;
import java.util.List;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private final String OPTION_LOCATOR_PREFIX = "//md-option/div[contains(.,'";
    private final String LOCATOR_POSTFIX = "')]/..";
    private final String MACHINE_CLASS_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_81']//div[contains(.,'";
    private final String MACHINE_SERIES_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_89']//div[contains(.,'";
    private final String MACHINE_TYPE_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_91']//div[contains(.,'";
    private final String GPU_NUMBER_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_395']//div[contains(.,'";
    private final String GPU_TYPE_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_397']//div[contains(.,'";
    private final String SSD_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_356']//div[contains(.,'";
    private final String DATA_CENTER_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_93']//div[contains(.,'";
    private final String COMMITED_USAGE_OPTION_LOCATOR_PREFIX = "//*[@id='select_container_100']//div[contains(.,'";
    private final String RESULT_FIELD_LOCATOR_PREFIX = "//div[@class='md-list-item-text ng-binding'][contains(.,'";
    private final By RESULT_BLOCK_LOCATOR = By.xpath("//md-card-content[@id='resultBlock']");
    private final By EMAIL_INPUT_LOCATOR = By.xpath("//input[@type='email']");
    private final By RESULT_INSTANCE_COUNT_LOCATOR = By.xpath("//span[@class='ng-binding ng-scope']");
    private final By RESULT_TOTAL_COST_LOCATOR = By.xpath("//h2/b[@class='ng-binding']");


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
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame(0);
        computeEngineIcon.click();

        logger.info("Chosen compute engine");
        return this;
    }

    public GoogleCloudCalculatorPage enterInstanceData(GoogleCloudComputerInstance instance) {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(instanceCountField))
                .sendKeys(instance.getInstanceCount() + "");
        osField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(OPTION_LOCATOR_PREFIX
                                + instance.getSystem()
                                + LOCATOR_POSTFIX
                        )))
                .click();
        machineClassField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(MACHINE_CLASS_OPTION_LOCATOR_PREFIX
                                + instance.getVmClass()
                                + LOCATOR_POSTFIX
                        )))
                .click();
        machineSeriesField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(MACHINE_SERIES_OPTION_LOCATOR_PREFIX
                                + instance.getSeries()
                                + LOCATOR_POSTFIX
                        )))
                .click();
        machineTypeField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(MACHINE_TYPE_OPTION_LOCATOR_PREFIX
                                + instance.getType()
                                + LOCATOR_POSTFIX
                        )))
                .click();
        if (instance.getGpuCount() > 0) {
            addGpuWithCertainType(instance.getGpuCount(), instance.getGpuType());
        }
        ssdTypeField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(SSD_OPTION_LOCATOR_PREFIX
                                + instance.getSsdType()
                                + LOCATOR_POSTFIX
                        )))
                .click();
        dataCenterLocationField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(DATA_CENTER_OPTION_LOCATOR_PREFIX
                                + instance.getDatacenter()
                                + LOCATOR_POSTFIX
                        )))
                .click();
        commitedUsageField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(COMMITED_USAGE_OPTION_LOCATOR_PREFIX
                                + instance.getUsage()
                                + LOCATOR_POSTFIX
                        )))
                .click();

        logger.info("Entered instance data");
        return this;
    }

    public GoogleCloudCalculatorPage addGpuWithCertainType(int number, String type) {
        gpuCheckbox.click();
        gpuNumberField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(GPU_NUMBER_OPTION_LOCATOR_PREFIX
                                + number
                                + LOCATOR_POSTFIX
                        )))
                .click();
        gpuTypeField.click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(GPU_TYPE_OPTION_LOCATOR_PREFIX
                                + type
                                + LOCATOR_POSTFIX
                        )))
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage addToEstimate() {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(addToEstimateButton))
                .click();
        logger.info("Added instance to estimate");
        return this;
    }

    public String getVMClass() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_FIELD_LOCATOR_PREFIX
                                + "VM class" +
                                LOCATOR_POSTFIX
                ))).getText().replace("VM class: ", "");
    }

    public String getInstanceType() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_FIELD_LOCATOR_PREFIX
                                + "Instance type" +
                                LOCATOR_POSTFIX
                ))).getText().replace("Instance type: ", "");
    }

    public String getDatacenter() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_FIELD_LOCATOR_PREFIX
                                + "Region" +
                                LOCATOR_POSTFIX
                ))).getText().replace("Region: ", "");
    }

    public String getSSDType() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_FIELD_LOCATOR_PREFIX
                                + "SSD" +
                                LOCATOR_POSTFIX
                ))).getText().replace("Total available local SSD space ", "").replace("i", "");
    }

    public String getCommitmentTerm() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        RESULT_FIELD_LOCATOR_PREFIX
                                + "Commitment term" +
                                LOCATOR_POSTFIX
                ))).getText().replace("Commitment term: ", "");
    }

    public String getEstimatedCost() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        RESULT_TOTAL_COST_LOCATOR
                )).getText()
                .replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    public int getInstanceCount() {
        return Integer.parseInt(new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        RESULT_INSTANCE_COUNT_LOCATOR
                )).getText().replaceAll("[\\D]", ""));
    }

    public GoogleCloudCalculatorPage sendEmail(String email) {
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame(0);
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(EMAIL_INPUT_LOCATOR));
        emailField.sendKeys(email);


        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        logger.info("Sent instance via email");
        return this;
    }

    @Override
    public GoogleCloudCalculatorPage openPage(String URL) {
        webDriver.get(URL);
        logger.info("Opened calculator page on " + URL);
        return this;
    }
}
