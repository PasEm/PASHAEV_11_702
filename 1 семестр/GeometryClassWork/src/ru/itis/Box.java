package ru.itis;

public class Box extends ShapeInSpace{
    private double height;
    private double weight;
    private double length;
    public Box(double x, double y, double z, double height, double weight, double length){
        super(x, y, z);
        this.height = height;
        this.weight = weight;
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }
}
