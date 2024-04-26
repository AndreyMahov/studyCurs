package org.mahov.polymorphism;

import org.mahov.polymorphism.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        SuperCar superCar = new SuperCar(25,0,250);
//        Bus bus = new Bus(150, 50, 100);
//        Truck truck = new Truck(250, 3,150);
//
//        List<Ride> carList = new ArrayList<>();
//        carList.add(superCar);
//        carList.add(bus);
//        carList.add(truck);
//
////        // динамическое связывание
////        carList.forEach(Ride::startRide);
//
//        // статичное связывание
//        superCar.enableTurbo(60);
//        superCar.enableTurbo(25);

        var list = List.of("1","2","1.0", "2.1");

        list.stream()
                .sorted()
                .forEach(System.out::println);

    }
}
