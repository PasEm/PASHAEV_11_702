package ru.itis;

import java.util.Random;

public class Point {
    private int x;
    private int y;

    public Point(){
        Random random = new Random();
        x = (random.nextInt(21) - 10);
        x = (x > 10) ? x - 10 : -x;
        y = random.nextInt(21) - 10;
        y = (y > 10) ? y - 10 : -y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoordinate(){
        StringBuilder coordinate = new StringBuilder();
        coordinate.append(x).append(' ').append(y);
        return coordinate.toString();
    }
}
