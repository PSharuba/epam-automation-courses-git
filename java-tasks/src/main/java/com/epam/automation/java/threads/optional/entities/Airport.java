package com.epam.automation.java.threads.optional.entities;

import java.util.concurrent.LinkedBlockingQueue;

public class Airport {
    private static final int RUNWAYS_COUNT = 5;

    private LinkedBlockingQueue<Runway> runways;

    public Airport() {
        runways = new LinkedBlockingQueue<>(RUNWAYS_COUNT);
        for (int i = 0; i < RUNWAYS_COUNT; i++) {
            runways.add(new Runway(i + 1));
        }
    }

    public LinkedBlockingQueue<Runway> getRunways() {
        return runways;
    }
}
