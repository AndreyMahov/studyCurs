package org.mahov.polymorphism.model;

public class SuperCar extends Car {

    public SuperCar(int tankCapacity, int passengers, int maxSpeed) {
        super(tankCapacity, passengers, maxSpeed);
    }

    public void enableTurbo(){
        System.out.println("start max Turbo");
    }

    public void enableTurbo(int turboPercentLevel){
        System.out.println("start turbo" + " percent: " + turboPercentLevel);
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
}
