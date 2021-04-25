package com.rahul.model;

public class Vehicle {
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    String registrationNumber;
    VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
}
