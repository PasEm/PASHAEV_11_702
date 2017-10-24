package ru.itis;

public class Ellips extends Shape{
    private double radius1;
    private double radius2;
    public Ellips(double radius1, double radius2){
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.square = radius1 * radius2 * 3.14;
        this.perimetr = 3.14 * (radius1 + radius2);
    }

    public double getRadius1() {
        return radius1;
    }

    public double getRadius2() {
        return radius2;
    }
}
