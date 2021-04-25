package com.rahul;

import com.rahul.exception.ParkingException;
import com.rahul.model.ParkingLot;
import com.rahul.model.Slot;
import com.rahul.model.Vehicle;
import com.rahul.model.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ApplicationDriver {
    public static void main(String[] args) throws ParkingException {
        //create slot vs vehicle cache
        //you can use guava BiMap to get slots by vehicle
        Map<String, Vehicle> cache = new HashMap<>();

        //create parking lot
        ParkingLot parkingLot = new ParkingLot(1, cache);

        //create vehicle
        Vehicle vehicle = new Vehicle("KA03MV4668", VehicleType.Car);

        //park vehicle
        Slot slot = parkingLot.park(vehicle);
        System.out.println(slot.getVehicle().getRegistrationNumber());
        System.out.println(cache.get(slot.getId()));
        System.out.println(slot.getVehicle());

        //unpark vehicle
        parkingLot.unpark(vehicle);
        System.out.println(slot.getVehicle());


    }
}
