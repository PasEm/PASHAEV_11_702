package ru.itis;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(2,3,2,4,6,3,6,4);
        Rectangle rectangle2 = new Rectangle(5, 4, 5,10,12,4,12,10);
        rectangle1.scale(2, 8);
        rectangle1.move(-4, -5);
        Rectangle rectangle3 = new Rectangle().createMaxRectangle(rectangle1, rectangle2);
    }
}
