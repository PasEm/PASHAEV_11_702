package ru.itis;

public class Sphere extends ShapeInSpace{
    private  double radius;
    public Sphere(double x, double y, double z, double radius){
        super(x, y, z);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
