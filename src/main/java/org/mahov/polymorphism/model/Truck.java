package org.mahov.polymorphism.model;

public class Truck extends Car implements Ride{
    public Truck(int tankCapacity, int passengers, int maxSpeed) {
        super(tankCapacity, passengers, maxSpeed);
    }

    @Override
    public int getTankCapacity() {
        return super.getTankCapacity();
    }

    @Override
    public void setTankCapacity(int tankCapacity) {
        super.setTankCapacity(tankCapacity);
    }

    @Override
    public int getPassengers() {
        return super.getPassengers();
    }

    @Override
    public void setPassengers(int passengers) {
        super.setPassengers(passengers);
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public void startRide() {
        System.out.println("Truc start ride");
    }
}
