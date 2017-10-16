package ru.itis;

public class Main {

    public static void main(String[] args) {
        ParkingPlace parking1 = new ParkingPlace("B38");
        ParkingPlace parking5 = new ParkingPlace("E45");
        Car car1 = new Car("Porsche", "black", 666);
        Car car5 = new Car("Mercedez", "blue", 777);
        Car car6 = new Car("Volvo", "grey", 444);
        car1.toPark(parking1);
        car5.toPark(parking5);
        car6.toPark(parking5);
        car1.toTake(parking1);
        car6.toTake(parking1);
        car6.toPark(parking5);
    }
}
