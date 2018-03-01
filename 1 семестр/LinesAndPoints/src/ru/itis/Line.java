package ru.itis;

import java.util.ArrayList;

public class Line {
    private ArrayList<Point> line;

    public Line() {
        line = new ArrayList<>();
    }

    public void addPoint(Point point){
        line.add(point);
    }

    public void  printLine() {
        for (Point point: line){
            System.out.print(point.getX() + " " + point.getY() + "  ");
        }
        System.out.println();
    }

    public Point getLastPoint(){
        return line.get(line.size() -1);
    }
}
