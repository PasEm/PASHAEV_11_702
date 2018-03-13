package ru.itis;

public class Point {
    private int x;
    private int y;
    private int floor;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(int floor, int x, int y){
        this.x = x;
        this.y = y;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
