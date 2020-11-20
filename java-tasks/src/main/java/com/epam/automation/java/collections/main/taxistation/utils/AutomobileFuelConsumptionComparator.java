package com.epam.automation.java.collections.main.taxistation.utils;

import com.epam.automation.java.collections.main.taxistation.entities.Automobile;

import java.util.Comparator;

public class AutomobileFuelConsumptionComparator implements Comparator<Automobile> {
    @Override
    public int compare(Automobile automobile1, Automobile automobile2) {
        if (automobile1.getFuelConsumption() > automobile2.getFuelConsumption()) {
            return 1;
        } else if (automobile1.getFuelConsumption() < automobile2.getFuelConsumption()) {
            return -1;
        }
        return 0;
    }
}
