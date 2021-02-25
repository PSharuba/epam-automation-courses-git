package com.epam.automation.java.threads.main.tunnel.entities;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Tunnel {
    private int trainsInQueue;
    private int id;
    private boolean occupied;
    private long length;
    private LinkedBlockingQueue<Train> rails;

    public Tunnel(int id, long length) {
        this.trainsInQueue = 0;
        this.id = id;
        if (length > 0)
            this.length = length;
        else
            throw new IllegalArgumentException("Length <=0 in Tunnel constructor. Length: " + length);
        occupied = false;
        rails = new LinkedBlockingQueue<>(1);
    }

    public boolean occupy(Train train, int waitTime) {
        boolean success = false;
        try {
            success = rails.offer(train, waitTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (success) {
            this.occupied = true;
            trainsInQueue++;
        }
        return success;
    }

    public void free() {
        try {
            if (occupied)
                rails.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.occupied = false;
        trainsInQueue--;
    }

    public int getTrainsInQueue() {
        return trainsInQueue;
    }

    public long getLength() {
        return length;
    }

    public int getId() {
        return id;
    }
}
