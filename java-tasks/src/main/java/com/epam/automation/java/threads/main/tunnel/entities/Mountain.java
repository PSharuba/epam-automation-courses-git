package com.epam.automation.java.threads.main.tunnel.entities;

import java.util.Random;

public class Mountain {
    private static final int MAX_TUNNEL_LENGTH = 1500;
    private static final int MIN_TUNNEL_LENGTH = 1000;

    private Tunnel firstTunnel;
    private Tunnel secondTunnel;

    public Mountain() {
        Random random = new Random();
        int dispersion = MAX_TUNNEL_LENGTH - MIN_TUNNEL_LENGTH;
        firstTunnel = new Tunnel(1, random.nextInt(dispersion) + MIN_TUNNEL_LENGTH);
        secondTunnel = new Tunnel(2, random.nextInt(dispersion) + MIN_TUNNEL_LENGTH);
    }

    public Tunnel getTunnel() {
        if (Math.random() < 0.5)
            return firstTunnel;
        return secondTunnel;
    }

    public Tunnel switchTunnel(Tunnel currentTunnel, long trainID) {
        Tunnel otherTunnel;

        if (currentTunnel == firstTunnel)
            otherTunnel = secondTunnel;
        else
            otherTunnel = firstTunnel;

        if (currentTunnel.getTrainsInQueue() > otherTunnel.getTrainsInQueue()) {
            System.out.println("Train №" + trainID + " switched tunnel");
            return otherTunnel;
        }
        System.out.println("Train №" + trainID + " remained on current tunnel");

        return currentTunnel;
    }
}
