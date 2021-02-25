package com.epam.automation.java.collections.main.taxistation.entities;

import com.epam.automation.java.collections.main.taxistation.enums.CargoCarType;

public class Truck extends Automobile {
    private CargoCarType type;
    private double maxWeight;
    private double cargoSpace;

    public Truck() {
    }

    public Truck(long id, int wheelsCount, double topSpeed, double fuelConsumption, double carPrice,
                 double mass, String brand, String model, double rentPrice, CargoCarType type,
                 double maxWeight, double cargoSpace) {
        super(id, wheelsCount, topSpeed, fuelConsumption, carPrice, mass, brand, model, rentPrice);
        this.type = type;
        this.maxWeight = maxWeight;
        this.cargoSpace = cargoSpace;
    }

    @Override
    public String toString() {
        return super.toString()
                .replace("Automobile{", "Truck{")
                .replace("}", ", type=" + type +
                        ", maxWeight=" + maxWeight +
                        ", cargoSpace=" + cargoSpace +
                        '}');
    }

    public CargoCarType getType() {
        return type;
    }

    public void setType(CargoCarType type) {
        this.type = type;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(double cargoSpace) {
        this.cargoSpace = cargoSpace;
    }
}
