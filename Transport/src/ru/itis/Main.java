package ru.itis;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        ParkingPlace park = new ParkingPlace("Lukashenko`s Parking", LocalTime.parse("10:00:00"), LocalTime.parse("17:00:00"));
        Airbus a1 = new Airbus("Boing-777", 10);
        Tank tank = new Tank("Panzer", 7);
        TractorBelarus lukashenko = new TractorBelarus("LUKASHENKOIsComing", 2, 500000);
        Car car1 = new Car("Volvo", 4);
        Sportcar car2 = new Sportcar("Ferrari", 5);
        park.parkTransport(a1);
        park.parkTransport(tank);
        park.parkTransport(car1);
        park.parkTransport(car2);
        park.parkTransport(lukashenko);
        park.takeTransport(tank);
        park.parkTransport(lukashenko);
        Transport.move(car2,50);
        Transport.move(car2,50);
        lukashenko.cartoshkaTime();
        car1.cartoshkaTime();
    }
}
