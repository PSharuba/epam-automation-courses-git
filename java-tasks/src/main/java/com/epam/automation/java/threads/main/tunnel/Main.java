package com.epam.automation.java.threads.main.tunnel;

import com.epam.automation.java.threads.main.tunnel.entities.Mountain;
import com.epam.automation.java.threads.main.tunnel.entities.Train;

public class Main {
    public static final int DEFAULT_TRAIN_COUNT = 20;

    public static void main(String[] args) {
        Mountain mountain = new Mountain();
        for (int i = 0; i < DEFAULT_TRAIN_COUNT; i++) {
            boolean isLeft = Math.random() < 0.5;
            new Train(i, isLeft, mountain).start();
        }
    }
}
