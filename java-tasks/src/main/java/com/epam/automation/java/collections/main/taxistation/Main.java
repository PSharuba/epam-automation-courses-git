package com.epam.automation.java.collections.main.taxistation;

import com.epam.automation.java.collections.main.taxistation.entities.Automobile;
import com.epam.automation.java.collections.main.taxistation.entities.TaxiStation;
import com.epam.automation.java.collections.main.taxistation.utils.AutomobileFuelConsumptionComparator;
import com.epam.automation.java.collections.main.taxistation.utils.AutomobileIdComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Pavel Sharuba 2020
 * Таксопарк. Определить иерархию легковых автомобилей.
 * Создать таксопарк.
 * Подсчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        TaxiStation taxiStation = new TaxiStation();

        ArrayList<Automobile> automobiles = (ArrayList<Automobile>) taxiStation.getAutomobiles();
        double priceOfAllAutomobiles = 0.;
        for (Automobile automobile : automobiles) {
            priceOfAllAutomobiles += automobile.getCarPrice();
        }
        System.out.println("\nCost of all automobiles on station: " + priceOfAllAutomobiles + " $");

        System.out.println("\nAll automobiles sorted by fuel consumption and id:");
        automobiles.sort(new AutomobileFuelConsumptionComparator().reversed().thenComparing(new AutomobileIdComparator()));
        for (Automobile automobile : automobiles) {
            System.out.println("ID: " + automobile.getId() + ", Fuel consumption: " + automobile.getFuelConsumption()
                    + "\n" + automobile.toString());
        }

        System.out.println("\nEnter max speed threshold in two lines. \nFormat:\nminspeed\nmaxspeed\n");
        double minSpeed = readDoubleFromConsole();
        double maxSpeed = readDoubleFromConsole();

        while (maxSpeed < minSpeed) {
            System.out.println("Max speed < min speed. Please reenter max speed");
            maxSpeed = readDoubleFromConsole();
        }

        System.out.println("\nAutomobiles that fit in speed threshold: ");
        automobiles.sort(new AutomobileIdComparator());

        for (Automobile automobile : automobiles) {
            if (automobile.getTopSpeed() >= minSpeed && automobile.getTopSpeed() <= maxSpeed) {
                System.out.println("\nID: " + automobile.getId() + ", top speed: " + automobile.getTopSpeed()
                        + "\n" + automobile.toString());
            }
        }
    }

    private static double readDoubleFromConsole() {
        double value;
        while (true) {
            try {
                Scanner inputScanner = new Scanner(System.in);
                value = inputScanner.nextDouble();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect double format. Split fractional part with ','");
            }
        }
        return value;
    }
}
