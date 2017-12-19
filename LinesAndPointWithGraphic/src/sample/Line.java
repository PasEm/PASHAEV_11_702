package sample;

import java.util.LinkedList;

public class Line {
    public LinkedList<Point> line;

    public Line() {
        line = new LinkedList<>();
    }

    public void addPoint(Point point){
        line.add(point);
    }

    public int getCount(){
        return line.size();
    }

    public Point getPoint (int index){
        return line.get(index);
    }
}
