package com.epam.automation.tests;

import com.epam.automation.model.Paste;
import com.epam.automation.pageobjects.pastebin.PastePage;
import com.epam.automation.service.PasteCreator;
import org.testng.annotations.Test;
import com.epam.automation.pageobjects.pastebin.PasteCreationPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PasteBinTests extends CommonConditions {
    public static final String PRE_MADE_PASTE_URL = "https://pastebin.com/6QFUzPtu";


    @Test
    public void createNewPasteAndCheckItsTextIsEqualToExpectedText() {
        Paste paste = PasteCreator.createNewPasteFromProperties();
        String pasteText = new PasteCreationPage(webDriver)
                .openPage()
                .fillPasteFields(paste)
                .postPaste()
                .getPasteText();
        assertThat(pasteText, is(equalTo(paste.getText())));
    }

    @Test
    public void createNewPasteAndCheckItsTitleIsEqualToExpectedTitle() {
        Paste paste = PasteCreator.createNewPasteFromProperties();
        String pasteTitle = new PasteCreationPage(webDriver)
                .openPage()
                .fillPasteFields(paste)
                .postPaste()
                .getPasteTitle();
        assertThat(pasteTitle, is(equalTo(paste.getTitle())));
    }

    @Test
    public void createNewPasteWithHighlightingAndCheckItsHighlightingIsEqualToExpectedHighlighting() {
        Paste paste = PasteCreator.createNewPasteFromProperties();
        String pasteHighlighting = new PasteCreationPage(webDriver)
                .openPage()
                .fillPasteFields(paste)
                .postPaste()
                .getPasteHighlighting();
        assertThat(pasteHighlighting, is(equalTo(paste.getHighlighting())));
    }

    @Test
    public void OpenPreMadePasteAndCheckItsTextIsEqualToExpectedText() {
        Paste paste = PasteCreator.createNewPasteFromProperties();
        String pasteText = new PastePage(webDriver)
                .openPage(PRE_MADE_PASTE_URL)
                .getPasteText();
        assertThat(pasteText, is(equalTo(paste.getText())));
    }

    @Test
    public void OpenPreMadePasteAndCheckItsTitleIsEqualToExpectedTitle() {
        Paste paste = PasteCreator.createNewPasteFromProperties();
        String pasteTitle = new PastePage(webDriver)
                .openPage(PRE_MADE_PASTE_URL)
                .getPasteTitle();
        assertThat(pasteTitle, is(equalTo(paste.getTitle())));
    }

    @Test
    public void OpenPreMadePasteAndCheckItsHighlightingIsEqualToExpectedHighlighting() {
        Paste paste = PasteCreator.createNewPasteFromProperties();
        String pasteHighlighting = new PastePage(webDriver)
                .openPage(PRE_MADE_PASTE_URL)
                .getPasteHighlighting();
        assertThat(pasteHighlighting, is(equalTo(paste.getHighlighting())));
    }
}
