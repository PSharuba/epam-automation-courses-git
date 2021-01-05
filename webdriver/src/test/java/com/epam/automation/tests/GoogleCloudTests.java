package com.epam.automation.tests;

import com.epam.automation.model.GoogleCloudComputerInstance;
import com.epam.automation.service.GoogleComputerInstanceCreator;
import org.testng.annotations.Test;
import com.epam.automation.pageobjects.AbstractPage;
import com.epam.automation.pageobjects.googlecloud.GoogleCloudCalculatorPage;
import com.epam.automation.pageobjects.googlecloud.GoogleCloudMainPage;
import com.epam.automation.pageobjects.tempmail.TenMinuteMailPage;
import com.epam.automation.service.DataReader;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleCloudTests extends CommonConditions {

    @Test
    public void FindGoogleCloudCalculatorCreateInstanceAndComparePriceWithPreComputed() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        String resultPrice = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate()
                .getEstimatedCost();

        assertThat(resultPrice, is(equalTo(instance.getExpectedPrice())));
    }

    @Test
    public void FindGoogleCloudCalculatorCreateInstanceAndCompareVMClassWithExpected() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        String vmClass = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate()
                .getVMClass();

        assertThat(vmClass, is(equalTo(instance.getVmClass().toLowerCase())));
    }

    @Test
    public void FindGoogleCloudCalculatorCreateInstanceAndCompareTypeWithExpected() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        String resultType = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate()
                .getInstanceType();

        assertThat(resultType, is(equalTo(instance.getType())));
    }

    @Test
    public void FindGoogleCloudCalculatorCreateInstanceAndCompareDatacenterWithExpected() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        String resultDatacenter = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate()
                .getDatacenter();

        assertThat(resultDatacenter, is(equalTo(instance.getDatacenter())));
    }

    @Test
    public void FindGoogleCloudCalculatorCreateInstanceAndCompareSSDWithExpected() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        String resultSSD = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate()
                .getSSDType();

        assertThat(resultSSD, is(equalTo(instance.getSsdType())));
    }

    @Test
    public void FindGoogleCloudCalculatorCreateInstanceAndCompareSystemWithExpected() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        int resultInstanceCount = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate()
                .getInstanceCount();

        assertThat(resultInstanceCount, is(equalTo(instance.getInstanceCount())));
    }

    @Test
    public void FindGoogleCloudCalculatorComputePriceSendEmailAndComparePrice() {
        String searchQuery = DataReader.readData("google.cloud.search.query");
        GoogleCloudComputerInstance instance = GoogleComputerInstanceCreator
                .createNewPasteFromProperties();

        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudMainPage(webDriver)
                .openPage()
                .enterSearchQuery(searchQuery)
                .chooseDesiredResult(searchQuery)
                .selectComputeEngine()
                .enterInstanceData(instance)
                .addToEstimate();

        String calculatorResultCost = calculatorPage.getEstimatedCost();
        ArrayList<String> tabs = AbstractPage.openNewTab(webDriver);

        TenMinuteMailPage mailPage = new TenMinuteMailPage(webDriver)
                .switchTab(tabs.get(1))
                .openPage();

        String emailAddress = mailPage.getEmailAddress();
        mailPage.switchTab(tabs.get(0));
        calculatorPage.sendEmail(emailAddress);
        String mailTotalCost = mailPage.switchTab(tabs.get(1))
                .getEstimatedCostFromMessage();

        assertThat(mailTotalCost, is(equalTo(calculatorResultCost)));
    }
}
