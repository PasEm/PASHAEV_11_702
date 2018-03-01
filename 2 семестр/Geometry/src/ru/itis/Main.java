package ru.itis;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
	    try(BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")))){
	        while(reader.ready()){
	            String input = reader.readLine();
	            double first, second;
	            first = Double.parseDouble(input.substring(0, input.indexOf(' ')));
	            second = Double.parseDouble(input.substring(input.indexOf(' ') + 1));
	            points.add(new Point(first, second));
            }
        }
        catch (IOException e){
	        throw new RuntimeException(e);
        }
        Shell quickShell = new Shell(points);
        ArrayList<Point> result = quickShell.getShell();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")))){
            for (int i = 0; i < result.size(); i++){
                StringBuilder output = new StringBuilder();
                output.append(result.get(i).getX()).append(' ').append(result.get(i).getY());
                writer.write(output.toString());
                writer.write('\n');
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
