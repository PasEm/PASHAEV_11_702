package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car1 = new Car();
        car1.going(scanner.nextInt());
        Car car2 = new Car(250, "Audi Q4");
        Car car3 = new Car ( 300, "Porsche Panamera", 0, "Black");
        System.out.println(car3.getPower() + " " + car3.getModel() + " " + car3.getDistance() + " " + car3.getColor());
        car3.going(scanner.nextInt());
    }
}
