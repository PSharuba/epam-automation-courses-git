package com.epam.automation.java.collections.main.taxistation;

import com.epam.automation.java.collections.main.taxistation.entities.Automobile;
import com.epam.automation.java.collections.main.taxistation.entities.TaxiStation;
import com.epam.automation.java.collections.main.taxistation.utils.AutomobileFuelConsumptionComparator;
import com.epam.automation.java.collections.main.taxistation.utils.AutomobileIdComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    private static double readDoubleFromConsole() throws IOException {
        double value;

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                value = Double.parseDouble(reader.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect double format. Split fractional part with '.'");
            }
        }
        return value;
    }
}
