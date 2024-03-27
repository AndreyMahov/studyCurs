package org.mahov.polymorphism;

import org.mahov.polymorphism.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new SuperCar(25,0,250));
        carList.add(new Bus(150, 50, 100));
        carList.add(new Truck(250, 3,150));


    }
}
