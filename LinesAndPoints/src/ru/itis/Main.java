package ru.itis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        File input = new File("C:\\Users\\bloof\\Desktop\\PASHAEV_11_702\\LinesAndPoints\\src\\ru\\itis\\input.txt");
        File output = new File("C:\\Users\\bloof\\Desktop\\PASHAEV_11_702\\LinesAndPoints\\src\\ru\\itis\\output.txt");
        Scanner scanner = new Scanner(input);
        FileWriter fr = new FileWriter(output);
        LinkedList<Line> lines = new LinkedList<>();
        LinkedList<Point> points = new LinkedList<>();
        while(scanner.hasNext()){
            points.add(new Point(scanner.nextInt(),scanner.nextInt()));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() > o2.getX()) {
                    return 0;
                }
                if (o2.getX() == o1.getX() && o1.getY() > o2.getY()){
                    return 0;
                }
                return -1;
            }
        });
        for (int i = 0; i < points.size();){
            lines.add(new Line());
            lines.get(lines.size() - 1).addPoint(points.get(0));
            fr.write(lines.get(lines.size() - 1).getLastPoint().getX() + " " + lines.get(lines.size() - 1).getLastPoint().getY() + " ; ");
            points.remove(0);
            for (int j = 0; j < points.size(); j++)
            {
                if (lines.get(lines.size() - 1).getLastPoint().getY() <= points.get(j).getY() && lines.get(lines.size() - 1).getLastPoint().getX() <= points.get(j).getX()){
                    lines.get(lines.size() - 1).addPoint(points.get(j));
                    fr.write(lines.get(lines.size() - 1).getLastPoint().getX() + " " + lines.get(lines.size() - 1).getLastPoint().getY() + " ; ");
                    points.remove(j);
                    j--;
                }
            }
            fr.write("\n");
        }
        fr.close();
    }
}