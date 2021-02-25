package com.epam.automation.java.fundamentals.main;

public class HelloUser {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello " + args[0] + "!");
        }
    }
}
