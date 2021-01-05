package com.epam.automation.service;

import com.epam.automation.model.Paste;

public class PasteCreator {
    private static final String DEFAULT_PREFIX = "pastebin";
    private static final String PASTE_TITLE_POSTFIX = "title";
    private static final String PASTE_TEXT_POSTFIX = "text";
    private static final String PASTE_HIGHLIGHTING_POSTFIX = "highlighting";
    private static final String PASTE_EXPIRATION_POSTFIX = "expiration";

    public static Paste createNewPasteFromProperties() {
        DataReader reader = new DataReader(DEFAULT_PREFIX);

        String title = reader.readDataWithPrefix(PASTE_TITLE_POSTFIX);
        String text = reader.readDataWithPrefix(PASTE_TEXT_POSTFIX);
        String highlighting = reader.readDataWithPrefix(PASTE_HIGHLIGHTING_POSTFIX);
        String expiration = reader.readDataWithPrefix(PASTE_EXPIRATION_POSTFIX);

        return new Paste(title, text, highlighting, expiration);
    }

    public static Paste createNewPasteFromPropertiesWithEmptyTitle(String properties) {
        DataReader reader = new DataReader(DEFAULT_PREFIX);

        String title = "";
        String text = reader.readDataWithPrefix(PASTE_TEXT_POSTFIX);
        String highlighting = reader.readDataWithPrefix(PASTE_HIGHLIGHTING_POSTFIX);
        String expiration = reader.readDataWithPrefix(PASTE_EXPIRATION_POSTFIX);

        return new Paste(title, text, highlighting, expiration);
    }

    public static Paste createNewPasteFromPropertiesWithEmptyText(String properties) {
        DataReader reader = new DataReader(DEFAULT_PREFIX);

        String title = reader.readDataWithPrefix(PASTE_TITLE_POSTFIX);
        String text = "";
        String highlighting = reader.readDataWithPrefix(PASTE_HIGHLIGHTING_POSTFIX);
        String expiration = reader.readDataWithPrefix(PASTE_EXPIRATION_POSTFIX);

        return new Paste(title, text, highlighting, expiration);
    }


}
