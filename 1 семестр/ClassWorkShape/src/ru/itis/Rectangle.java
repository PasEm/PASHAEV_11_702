package ru.itis;

public class Rectangle extends Shape{
    private double length;
    private double width;
    public Rectangle(double length, double width){
        this.perimetr = (length + width) * 2;
        this.square = length * width;
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
