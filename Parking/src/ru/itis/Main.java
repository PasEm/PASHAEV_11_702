package ru.itis;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        ParkingPlace parking = new ParkingPlace("Parking 1", LocalTime.parse("00:00:00"), LocalTime.parse("21:00:00"));
        Car car1 = new Car("Porsche", "black", 666);
        Car car5 = new Car("Mercedez", "blue", 777);
        Car car6 = new Car("Volvo", "grey", 444);
        car1.toPark(parking);
        car5.toPark(parking);
        car6.toPark(parking);
        car1.toTake(parking);
        car6.toTake(parking);
        car6.toPark(parking);
    }
}
