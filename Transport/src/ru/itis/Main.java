package ru.itis;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        ParkingPlace park = new ParkingPlace("Lukashenko`s Parking", LocalTime.parse("10:00:00"), LocalTime.parse("17:00:00"));
        Airbus a1 = new Airbus("Boing-777 (Eifel is coming)", 10);
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
        car2.move(50);
        car2.move(50);
        tank.move(200);
        lukashenko.cartoshkaTime();
    }
}
