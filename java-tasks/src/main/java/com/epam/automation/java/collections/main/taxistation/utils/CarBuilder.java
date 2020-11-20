package com.epam.automation.java.collections.main.taxistation.utils;

import com.epam.automation.java.collections.main.taxistation.entities.Automobile;
import com.epam.automation.java.collections.main.taxistation.entities.Car;
import com.epam.automation.java.collections.main.taxistation.entities.Truck;
import com.epam.automation.java.collections.main.taxistation.enums.CargoCarType;
import com.epam.automation.java.collections.main.taxistation.enums.PassengerCarType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarBuilder {
    public List<Automobile> readAutomobilesFromFile(String fileAddress) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
        List<Automobile> automobiles = new ArrayList<>();

        Map<String, Integer> fieldsMap = new HashMap<>();
        if (reader.ready()) {
            String[] values = reader.readLine().split(",");
            int counter = 0;
            for (String value : values) {
                fieldsMap.put(value, counter++);
            }
        } else {
            return automobiles;
        }

        while (reader.ready()) {
            String[] values = reader.readLine().split(",");
            long id = Long.parseLong(values[fieldsMap.get("id")]);
            int wheelsCount = Integer.parseInt(values[fieldsMap.get("wheelsCount")]);
            double topSpeed = Double.parseDouble(values[fieldsMap.get("topSpeed")]);
            double fuelConsumption = Double.parseDouble(values[fieldsMap.get("fuelConsumption")]);
            double carPrice = Double.parseDouble(values[fieldsMap.get("carPrice")]);
            double mass = Double.parseDouble(values[fieldsMap.get("mass")]);
            String brand = values[fieldsMap.get("brand")];
            String model = values[fieldsMap.get("model")];
            double rentPrice = Double.parseDouble(values[fieldsMap.get("rentPrice")]);
            boolean isCargoCar = Boolean.parseBoolean(values[fieldsMap.get("isCargoCar")]);

            if (isCargoCar) {
                CargoCarType type = CargoCarType.valueOf(values[fieldsMap.get("cargoType")].toUpperCase());
                double maxWeight = Double.parseDouble(values[fieldsMap.get("maxWeight")]);
                double cargoSpace = Double.parseDouble(values[fieldsMap.get("cargoSpace")]);

                automobiles.add(new Truck(id, wheelsCount, topSpeed, fuelConsumption, carPrice,
                        mass, brand, model, rentPrice, type,
                        maxWeight, cargoSpace));
            } else {
                int seatsCount = Integer.parseInt(values[fieldsMap.get("seatsCount")]);
                int doorsCount = Integer.parseInt(values[fieldsMap.get("doorsCount")]);
                PassengerCarType type = PassengerCarType.valueOf(values[fieldsMap.get("passengerType")].toUpperCase());
                String location = values[fieldsMap.get("location")];

                automobiles.add(new Car(id, wheelsCount, topSpeed, fuelConsumption, carPrice,
                        mass, brand, model, rentPrice, seatsCount,
                        doorsCount, type, location));
            }
        }
        return automobiles;
    }
}
