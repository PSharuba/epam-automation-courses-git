package com.epam.automation.java.threads.main.tunnel.entities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Train extends Thread {
    private static final int MAX_WAIT_TIME = 10;
    private static final Random RANDOM = new Random();

    private long id;
    private int waitTime;
    private boolean isLeftSide;
    private Mountain mountain;

    public Train(long id, boolean isLeftSide, Mountain mountain) {
        waitTime = RANDOM.nextInt(MAX_WAIT_TIME) + 5;
        this.id = id;
        this.isLeftSide = isLeftSide;
        this.mountain = mountain;
    }

    @Override
    public void run() {
        Tunnel tunnel = null;
        try {
            tunnel = mountain.getTunnel();
            while (!tunnel.occupy(this, waitTime)) {
                tunnel = mountain.switchTunnel(tunnel, id);
            }
            System.out.printf("Train №%2d entered tunnel №%d from %s \n", id, tunnel.getId(), (isLeftSide ? "left side" : "right side"));
            TimeUnit.MILLISECONDS.sleep(tunnel.getLength());
            System.out.printf("Train №%2d left tunnel №%d \nTravelled %4d meters\n", id, tunnel.getId(), tunnel.getLength());
            tunnel.free();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Train №" + id;
    }
}
