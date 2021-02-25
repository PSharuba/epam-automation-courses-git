package com.epam.automation.java.collections.main.taxistation.entities;

import com.epam.automation.java.collections.main.taxistation.utils.CarBuilder;

import java.io.IOException;
import java.util.List;

public class TaxiStation {
    private List<Automobile> automobiles;
    private static final String FILE_ADDRESS = "src/main/resources/automobiles.csv";

    public TaxiStation() throws IOException {
        automobiles = new CarBuilder().readAutomobilesFromFile(FILE_ADDRESS);
    }

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobilesFromFile(String fileAddress) throws IOException {
        this.automobiles = new CarBuilder().readAutomobilesFromFile(fileAddress);
    }
}
