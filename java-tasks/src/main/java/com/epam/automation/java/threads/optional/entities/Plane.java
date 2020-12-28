package com.epam.automation.java.threads.optional.entities;

import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private static final int TIME_TO_TAKE_OFF = 3;

    private int id;
    private Airport airport;

    public Plane(int id, Airport airport) {
        this.id = id;
        if (airport == null) throw new IllegalArgumentException("Null airport in Plane constructor");
        this.airport = airport;
    }

    @Override
    public void run() {
        try {
            System.out.println("Plane " + id + " wants to take off");
            Runway runway = airport.getRunways().take();
            System.out.println("Plane " + id + " entered runway " + runway.getId());
            TimeUnit.SECONDS.sleep(TIME_TO_TAKE_OFF);
            System.out.println("Plane " + id + " took off");
            airport.getRunways().put(runway);
            System.out.println("Runway " + runway.getId() + " is free");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
