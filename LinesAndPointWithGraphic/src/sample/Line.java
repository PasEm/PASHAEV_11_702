package sample;

import java.util.ArrayList;

public class Line {
    private ArrayList<Point> line;

    public Line() {
        line = new ArrayList<>();
    }

    public void addPoint(Point point){
        line.add(point);
    }

    public Point getLastPoint(){
        return line.get(line.size() -1);
    }
}
