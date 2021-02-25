package com.epam.automation.pageobjects.googlecloud;

import com.epam.automation.model.GoogleCloudComputerInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.automation.pageobjects.AbstractPage;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private final String OPTION_LOCATOR = "//md-option/div[contains(.,'%s')]/..";
    private final String MACHINE_CLASS_OPTION_LOCATOR = "//*[@id='select_container_81']//div[contains(.,'%s')]/..";
    private final String MACHINE_SERIES_OPTION_LOCATOR = "//*[@id='select_container_89']//div[contains(.,'%s')]/..";
    private final String MACHINE_TYPE_OPTION_LOCATOR = "//*[@id='select_container_91']//div[contains(.,'%s')]/..";
    private final String GPU_NUMBER_OPTION_LOCATOR = "//*[@id='select_container_395']//div[contains(.,'%s')]/..";
    private final String GPU_TYPE_OPTION_LOCATOR = "//*[@id='select_container_397']//div[contains(.,'%s')]/..";
    private final String SSD_OPTION_LOCATOR = "//*[@id='select_container_356']//div[contains(.,'%s')]/..";
    private final String DATA_CENTER_OPTION_LOCATOR = "//*[@id='select_container_93']//div[contains(.,'%s')]/..";
    private final String COMMITED_USAGE_OPTION_LOCATOR = "//*[@id='select_container_100']//div[contains(.,'%s')]/..";
    private final String RESULT_FIELD_LOCATOR = "//div[@class='md-list-item-text ng-binding'][contains(.,'%s')]/..";
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
        waitForElementToBeClickable(instanceCountField, 10)
                .sendKeys(instance.getInstanceCount() + "");

        osField.click();
        waitForElementToBeClickable(String.format(OPTION_LOCATOR, instance.getSystem()), 10)
                .click();

        machineClassField.click();
        waitForElementToBeClickable(String.format(MACHINE_CLASS_OPTION_LOCATOR, instance.getVmClass()), 10)
                .click();

        machineSeriesField.click();
        waitForElementToBeClickable(String.format(MACHINE_SERIES_OPTION_LOCATOR, instance.getSeries()), 10)
                .click();

        machineTypeField.click();
        waitForElementToBeClickable(String.format(MACHINE_TYPE_OPTION_LOCATOR, instance.getType()), 10)
                .click();

        if (instance.getGpuCount() > 0) {
            addGpuWithCertainType(instance.getGpuCount(), instance.getGpuType());
        }

        ssdTypeField.click();
        waitForElementToBeClickable(String.format(SSD_OPTION_LOCATOR, instance.getSsdType()), 10)
                .click();

        dataCenterLocationField.click();
        waitForElementToBeClickable(String.format(DATA_CENTER_OPTION_LOCATOR, instance.getDatacenter()), 10)
                .click();

        commitedUsageField.click();
        waitForElementToBeClickable(String.format(COMMITED_USAGE_OPTION_LOCATOR, instance.getUsage()), 10)
                .click();

        logger.info("Entered instance data");
        return this;
    }

    public GoogleCloudCalculatorPage addGpuWithCertainType(int number, String type) {
        gpuCheckbox.click();
        gpuNumberField.click();
        waitForElementToBeClickable(String.format(GPU_NUMBER_OPTION_LOCATOR, number), 10)
                .click();

        gpuTypeField.click();
        waitForElementToBeClickable(String.format(GPU_TYPE_OPTION_LOCATOR, type), 10)
                .click();
        return this;
    }

    public GoogleCloudCalculatorPage addToEstimate() {
        waitForElementToBeClickable(addToEstimateButton, 10)
                .click();
        logger.info("Added instance to estimate");
        return this;
    }

    public String getVMClass() {
        return waitForElementPresence(String.format(RESULT_FIELD_LOCATOR, "VM class"), 10)
                .getText().replace("VM class: ", "");
    }

    public String getInstanceType() {
        return waitForElementPresence(String.format(RESULT_FIELD_LOCATOR, "Instance type"), 10)
                .getText().replace("Instance type: ", "");
    }

    public String getDatacenter() {
        return waitForElementPresence(String.format(RESULT_FIELD_LOCATOR, "Region"), 10)
                .getText().replace("Region: ", "");
    }

    public String getSSDType() {
        return waitForElementPresence(String.format(RESULT_FIELD_LOCATOR, "SSD"), 10)
                .getText().replace("Total available local SSD space ", "")
                .replace("i", "");
    }

    public String getCommitmentTerm() {
        return waitForElementPresence(String.format(RESULT_FIELD_LOCATOR, "Commitment term"), 10)
                .getText().replace("Commitment term: ", "");
    }

    public String getEstimatedCost() {
        return waitForElementPresence(RESULT_TOTAL_COST_LOCATOR, 10)
                .getText()
                .replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    public int getInstanceCount() {
        return Integer.parseInt(waitForElementPresence(RESULT_INSTANCE_COUNT_LOCATOR, 10)
                .getText().replaceAll("[\\D]", ""));
    }

    public GoogleCloudCalculatorPage sendEmail(String email) {
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame(0);
        waitForElementToBeClickable(emailEstimateButton, 10).click();
        waitForElementToBeClickable(EMAIL_INPUT_LOCATOR, 10);
        emailField.sendKeys(email);
        waitForElementToBeClickable(sendEmailButton, 10).click();
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
