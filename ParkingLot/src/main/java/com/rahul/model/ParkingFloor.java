package com.rahul.model;

import java.util.*;

public class ParkingFloor {
    int parkingFloorId;
    Map<VehicleType, List<Slot>> slots;
    public static final int SLOTS_PER_VEHICLE_TYPE = 1;

    public ParkingFloor(int parkingFloorId) {
        this.parkingFloorId = parkingFloorId;
        slots = new HashMap();

        for (VehicleType vehicleType: VehicleType.values()){
            Slot[] slots = new Slot[SLOTS_PER_VEHICLE_TYPE];
            for(int i = 0; i < SLOTS_PER_VEHICLE_TYPE; i++){
                slots[i] = new Slot(parkingFloorId + ":" + i);
            }
            this.slots.put(vehicleType, Arrays.asList(slots));
        }
    }

    public boolean hasEmptySlot(VehicleType vehicleType){
        List<Slot> slotsByVehicleType = this.slots.get(vehicleType);
        for(Slot slot: slotsByVehicleType){
            if(slot.isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    public Slot getSlot(VehicleType vehicleType){
        List<Slot> slotsByVehicleType = this.slots.get(vehicleType);
        for(Slot slot: slotsByVehicleType){
            if(slot.isEmpty()){
                return slot;
            }
        }
        return null;
    }
}
