package org.mahov.polymorphism.model;

public abstract class Car {
    private int tankCapacity;
    private int passengers;

    private int maxSpeed;

    public Car(int tankCapacity, int passengers, int maxSpeed) {
        this.tankCapacity = tankCapacity;
        this.passengers = passengers;
        this.maxSpeed = maxSpeed;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
