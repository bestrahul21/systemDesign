package com.rahul.model;

import com.rahul.exception.ParkingException;

import java.util.*;

public class ParkingLot {
    List<ParkingFloor> parkingFloors;
    Map<String, Vehicle> slotVsVehicleCache;

    public ParkingLot(Integer n, Map<String, Vehicle> slotVsVehicleCache) {
        this.parkingFloors = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            parkingFloors.add(new ParkingFloor(i));
        }
        this.slotVsVehicleCache = slotVsVehicleCache;
    }

    public Slot park(Vehicle vehicle) throws ParkingException {
        Slot slot = null;
        for(ParkingFloor parkingFloor: parkingFloors){
            if(parkingFloor.hasEmptySlot(vehicle.vehicleType)){
                slot = parkingFloor.getSlot(vehicle.vehicleType);
            }
        }
        if(slot == null){
            throw new ParkingException("Parking is Full");
        }
        slot.occupy(vehicle);
        slotVsVehicleCache.put(slot.id, vehicle);
        return slot;
    }

    public boolean unpark(Vehicle vehicle) throws ParkingException {
        Optional<String> slotId = slotVsVehicleCache.entrySet().stream()
                .filter(stringVehicleEntry -> stringVehicleEntry.getValue().equals(vehicle))
                .map(Map.Entry::getKey)
                .findFirst();
        Slot slot = getSlot(slotId.orElseThrow(() -> new ParkingException("is vehicle even parked?")));
        slot.free(vehicle);
        return true;
    }

    public Slot getSlot(String slotId) throws ParkingException {
        return parkingFloors.stream()
                .map(parkingFloor -> parkingFloor.slots.values())
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .filter(slot -> slot.getId().equals(slotId))
                .findFirst().orElseThrow(() -> new ParkingException(" slot id not found"));
    }
}
