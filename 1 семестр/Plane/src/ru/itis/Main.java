package ru.itis;

import java.io.*;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        File output = new File("output.txt");
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(output));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        Random random = new Random();
        LinkedList<String> points = new LinkedList<>();
        for (int i = 0; i < random.nextInt(100); i++){
            Point point = new Point();
            String coordinate = point.getCoordinate();
            if (points.contains(coordinate)){
                points.remove(coordinate);
            }
            points.add(coordinate);
        }
        for (int i = 0; i < points.size(); i++){
            try{
                writer.write(points.get(i));
                writer.newLine();
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}