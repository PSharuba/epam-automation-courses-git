package com.epam.automation.service;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DataReader {
    private ResourceBundle resourceBundle;
    private String prefix;

    public DataReader(String prefix) {
        resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));
        this.prefix = prefix;
    }

    public String readDataWithPrefix(String key) {
        try {
            return resourceBundle.getString(prefix + "." + key);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    public static String readData(String key) {
        try {
            return ResourceBundle.getBundle(System.getProperty("env")).getString(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
