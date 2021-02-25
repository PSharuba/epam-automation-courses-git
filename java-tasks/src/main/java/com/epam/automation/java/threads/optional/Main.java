package com.epam.automation.java.threads.optional;

import com.epam.automation.java.threads.optional.entities.Airport;
import com.epam.automation.java.threads.optional.entities.Plane;

public class Main {
    private static final int PLANES_COUNT = 10;

    public static void main(String[] args) {
        Airport airport = new Airport();
        for (int i = 0; i < PLANES_COUNT; i++) {
            new Plane(i + 1, airport).start();
        }
    }
}
