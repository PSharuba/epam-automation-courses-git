package tests.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.pastebin.PasteCreationPage;
import pageobjects.pastebin.PastePage;
import service.DataReader;

public class PasteBinTests {
    private WebDriver webDriver;
    //Using pre-made paste to avoid pastebin guest restrictions
    private String pasteURL = "https://pastebin.com/6QFUzPtu";


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void createNewPasteAndCheckItIsNotEmpty() {
        DataReader reader = new DataReader("ICanWin", "pastebin");
        String pasteText = new PasteCreationPage(webDriver)
                .openPage("https://pastebin.com/")
                .writePasteText(reader.readData("text"))
                .setPasteTitle(reader.readData("title"))
                .setExpiration(reader.readData("expiration"))
                .postPaste()
                .getPasteText();
        Assert.assertEquals(pasteText, reader.readData("text"), "Expected text and result are not equal.\n");
    }

    @Test
    public void createNewPasteWithHighlightingAndCheckItsResult() {
        DataReader reader = new DataReader("BringItOn", "pastebin");
        String pasteText = new PasteCreationPage(webDriver)
                .openPage("https://pastebin.com/")
                .writePasteText(reader.readData("text"))
                .setPasteTitle(reader.readData("title"))
                .setExpiration(reader.readData("expiration"))
                .setHighlighting(reader.readData("highlighting"))
                .postPaste()
                .getPasteText();
        pasteURL = webDriver.getCurrentUrl();
        Assert.assertEquals(pasteText, reader.readData("text"), "Expected text and result are not equal.\n");
    }

    @Test
    public void checkPreMadePasteText() {
        DataReader reader = new DataReader("BringItOn", "pastebin");
        String pasteText = new PastePage(webDriver)
                .openPage(pasteURL)
                .getPasteText();
        pasteURL = webDriver.getCurrentUrl();
        Assert.assertEquals(pasteText, reader.readData("text"), "Expected text and result are not equal.\n");
    }

    @Test
    public void checkPreMadePasteTitle() {
        DataReader reader = new DataReader("BringItOn", "pastebin");
        webDriver.get(pasteURL);
        String pasteTitle = webDriver.getTitle();
        Assert.assertTrue(pasteTitle.contains(reader.readData("title"))
                , "Page title doesnt contain expected title" +
                        "\nExpected: " + reader.readData("title") +
                        "\nGot: " + pasteTitle);
    }

    @Test
    public void checkPreMadePasteHighlighting() {
        DataReader reader = new DataReader("BringItOn", "pastebin");
        String pasteHighlighting = new PastePage(webDriver)
                .openPage(pasteURL)
                .getPasteHighlighting();
        Assert.assertEquals(pasteHighlighting, reader.readData("highlighting"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        webDriver.quit();
        webDriver = null;
    }
}
