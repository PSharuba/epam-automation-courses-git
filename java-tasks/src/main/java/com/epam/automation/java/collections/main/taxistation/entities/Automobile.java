package com.epam.automation.java.collections.main.taxistation.entities;

import java.util.Objects;

public class Automobile {
    private long id;
    private int wheelsCount;
    private double topSpeed;
    private double fuelConsumption;
    private double carPrice;
    private double rentPrice;
    private double mass;
    private String brand;
    private String model;

    public Automobile() {
    }

    public Automobile(long id, int wheelsCount, double topSpeed, double fuelConsumption, double carPrice, double mass, String brand, String model, double rentPrice) {
        this.id = id;
        this.wheelsCount = wheelsCount;
        this.topSpeed = topSpeed;
        this.fuelConsumption = fuelConsumption;
        this.carPrice = carPrice;
        this.rentPrice = rentPrice;
        this.mass = mass;
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "id=" + id +
                ", wheelsCount=" + wheelsCount +
                ", topSpeed=" + topSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", carPrice=" + carPrice +
                ", rentPrice=" + rentPrice +
                ", mass=" + mass +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    @Override
//    public int compareTo(Automobile automobile) {
//        double fuelConsumptionDifference = fuelConsumption - automobile.getFuelConsumption();
//        if (fuelConsumptionDifference > 0) {
//            return 1;
//        } else if (fuelConsumptionDifference < 0) {
//            return -1;
//        }
//        return 0;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return id == that.id &&
                wheelsCount == that.wheelsCount &&
                Double.compare(that.topSpeed, topSpeed) == 0 &&
                Double.compare(that.fuelConsumption, fuelConsumption) == 0 &&
                Double.compare(that.carPrice, carPrice) == 0 &&
                Double.compare(that.rentPrice, rentPrice) == 0 &&
                Double.compare(that.mass, mass) == 0 &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wheelsCount, topSpeed, fuelConsumption, carPrice, rentPrice, mass, brand, model);
    }
}
