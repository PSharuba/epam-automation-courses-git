package com.epam.automation.java.collections.main.taxistation.entities;

import com.epam.automation.java.collections.main.taxistation.enums.PassengerCarType;

public class Car extends Automobile {

    private int seatsCount;
    private int doorsCount;
    private PassengerCarType type;
    private String location;

    public Car() {
    }


    public Car(long id, int wheelsCount, double topSpeed, double fuelConsumption, double carPrice,
               double mass, String brand, String model, double rentPrice, int seatsCount,
               int doorsCount, PassengerCarType type, String location) {

        super(id, wheelsCount, topSpeed, fuelConsumption, carPrice, mass, brand, model, rentPrice);
        this.seatsCount = seatsCount;
        this.doorsCount = doorsCount;
        this.type = type;
        this.location = location;
    }

    @Override
    public String toString() {
        return super.toString()
                .replace("Automobile{", "Car{")
                .replace("}", ", seatsCount=" + seatsCount +
                ", doorsCount=" + doorsCount +
                ", type=" + type +
                ", location='" + location + '\'' +
                '}');
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public PassengerCarType getType() {
        return type;
    }

    public void setType(PassengerCarType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
