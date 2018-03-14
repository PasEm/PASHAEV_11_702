package ru.itis;

import java.util.Objects;

public class Point {
    private int x;
    private int y;
    private int floor;

    /*public Point(int x, int y){
        this.x = x;
        this.y = y;
    }*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && floor == point.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, floor);
    }
}
