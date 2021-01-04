package tests.googlecloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AbstractPage;
import pageobjects.googlecloud.GoogleCloudCalculatorPage;
import pageobjects.googlecloud.GoogleCloudMainPage;
import pageobjects.tempmail.TenMinuteMailPage;
import service.DataComparator;
import service.DataReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class GoogleCloudTests {
    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public void FindGoogleCloudCalculatorComputePriceAndCompareWithPreComputed() {
        DataReader reader = new DataReader("HurtMePlenty", "google.cloud");
        HashMap<String, String> results = new GoogleCloudMainPage(webDriver)
                .openPage(reader.readData("search.URL"))
                .enterSearchQuery(reader.readData("search.query"))
                .chooseDesiredResult(reader.readData("search.query"))
                .selectComputeEngine()
                .enterInstancesNumber(reader.readData("instance.number"))
                .selectOS(reader.readData("system"))
                .selectMachineClass(reader.readData("vmClass"))
                .selectMachineSeries(reader.readData("instance.series"))
                .selectMachineType(reader.readData("instance.type"))
                .addGpuWithCertainType(reader.readData("gpu.count"), reader.readData("gpu.type"))
                .setSSD(reader.readData("ssd"))
                .setDataCenterLocation(reader.readData("datacenter"))
                .setCommitedUsage(reader.readData("usage"))
                .addToEstimate()
                .getResults();
        Assert.assertTrue(DataComparator.compareData(results, reader), "Received: " + results.toString());
    }

    @Test
    public void FindGoogleCloudCalculatorComputePriceSendEmailAndComparePrice() {
        DataReader reader = new DataReader("HurtMePlenty", "google.cloud");
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudMainPage(webDriver)
                .openPage(reader.readData("search.URL"))
                .enterSearchQuery(reader.readData("search.query"))
                .chooseDesiredResult(reader.readData("search.query"))
                .selectComputeEngine()
                .enterInstancesNumber(reader.readData("instance.number"))
                .selectOS(reader.readData("system"))
                .selectMachineClass(reader.readData("vmClass"))
                .selectMachineSeries(reader.readData("instance.series"))
                .selectMachineType(reader.readData("instance.type"))
                .addGpuWithCertainType(reader.readData("gpu.count"), reader.readData("gpu.type"))
                .setSSD(reader.readData("ssd"))
                .setDataCenterLocation(reader.readData("datacenter"))
                .setCommitedUsage(reader.readData("usage"))
                .addToEstimate();
        String resultCost = calculatorPage.getEstimatedCost();


        ArrayList<String> tabs = AbstractPage.openNewTab(webDriver);

        TenMinuteMailPage mailPage = new TenMinuteMailPage(webDriver)
                .switchTab(tabs.get(1))
                .openPage(reader.readData("mail.URL"));
        String emailAddress = mailPage.getEmailAddress();
        mailPage.switchTab(tabs.get(0));
        calculatorPage.sendEmail(emailAddress);

        String mailTotalCost = mailPage.switchTab(tabs.get(1))
                .getEstimatedCostFromMessage();

        Assert.assertEquals(mailTotalCost, resultCost);
    }
}
