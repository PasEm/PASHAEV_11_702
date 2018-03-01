package ru.itis;

public class Rectangle {
    private double coord1X, coord1Y, coord2X, coord2Y, coord3X, coord3Y, coord4X, coord4Y;

    public Rectangle(){
        this(0,0,0,0,0,0,0,0);
    }

    public Rectangle(double coord1X, double coord1Y, double coord2X, double coord2Y, double coord3X, double coord3Y, double coord4X, double coord4Y){
        this.coord1X = coord1X;
        this.coord1Y = coord1Y;
        this.coord2X = coord2X;
        this.coord2Y = coord2Y;
        this.coord3X = coord3X;
        this.coord3Y = coord3Y;
        this.coord4X = coord4X;
        this.coord4Y = coord4Y;
    }

    public void move(double axisX, double axisY){
        this.coord1X += axisX;
        this.coord1Y += axisY;
        this.coord2X += axisX;
        this.coord2Y += axisY;
        this.coord3X += axisX;
        this.coord3Y += axisY;
        this.coord4X += axisX;
        this.coord4Y += axisY;
    }

    public void scale(double length, double height){
        this.coord3X = length + this.coord1X;
        this.coord3Y = height + this.coord1Y;
        this.coord2Y = this.coord3Y;
        this.coord4X = this.coord3X;
    }

    public Rectangle createMaxRectangle(Rectangle rectangle1, Rectangle rectangle2){
        double length1 = rectangle1.getCoord3X() - rectangle1.getCoord1X();
        double length2 = rectangle2.getCoord3X() - rectangle2.getCoord1X();
        double height1 = rectangle1.getCoord3Y() - rectangle1.getCoord1Y();
        double height2 = rectangle2.getCoord3Y() - rectangle2.getCoord1Y();
        double length, height;
        length = length1 > length2 ? length1 : length2;
        height = height1 > height2 ? height1 : height2;
        return new Rectangle(0, 0, 0, height, length, 0,length, height);
    }

    public double getCoord1X() {
        return coord1X;
    }

    public double getCoord1Y() {
        return coord1Y;
    }

    public double getCoord3X() {
        return coord3X;
    }

    public double getCoord3Y() {
        return coord3Y;
    }
}
