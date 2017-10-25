package ru.itis;

public class Main {

    public static void main(String[] args) {
        Transport trans = new Transport("Transport Parkking", 0);
        Airbus a1 = new Airbus("Boing-777", 10);
        Tank tank = new Tank("Panzer", 7);
        TractorBelarus lukashenkoIsComing = new TractorBelarus("LUKASHENKO", 2, 500000);
        Car car1 = new Car("Volvo", 4);
        Sportcar car2 = new Sportcar("Ferrari", 5);
        trans.parkTransport(a1);
        trans.parkTransport(tank);
        trans.parkTransport(car1);
        trans.parkTransport(car2);
        trans.parkTransport(lukashenkoIsComing);
        trans.takeTransport(tank);
        trans.parkTransport(lukashenkoIsComing);
        Transport.move(car2,50);
        Transport.move(car2,50);
    }
}
