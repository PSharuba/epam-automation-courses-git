package service;

import java.util.ResourceBundle;

public class DataReader {
    private ResourceBundle resourceBundle;
    private String prefix;

    public DataReader(String propertiesBundle, String prefix) {
        resourceBundle = ResourceBundle.getBundle(propertiesBundle);
        this.prefix = prefix;
    }

    public String readData(String key) {
        return resourceBundle.getString(prefix + "." + key);
    }
}
