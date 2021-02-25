package com.epam.automation.java.fundamentals.main;

import java.util.ArrayList;

public class CommandLineArgumentsSunMultiplication {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        double sum = 0;
        double product = 1;

        for (String argument : args) {
            try {
                numbers.add(Double.valueOf(argument));
            } catch (NumberFormatException ex) {
                System.out.println("Argument " + argument + " is ignored.");
            }

        }

        for (Double number : numbers) {
            sum += number;
            product *= number;
        }

        System.out.println("Sum: " + sum + "\nProduct: " + product);
    }
}
