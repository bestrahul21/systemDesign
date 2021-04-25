package com.rahul.model;

public class Slot {
    public String getId() {
        return id;
    }

    String id;

    public Vehicle getVehicle() {
        return vehicle;
    }

    Vehicle vehicle;

    public Slot(String id) {
        this.id = id;
    }

    public boolean isEmpty(){
        return vehicle == null;
    }

    public void occupy(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void free(Vehicle vehicle){
        this.vehicle = null;
    }
}
