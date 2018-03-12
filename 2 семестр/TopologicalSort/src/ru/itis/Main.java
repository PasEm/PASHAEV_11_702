package ru.itis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        GraphCreater creater = GraphCreater.getGraphCreater();
        for (int i = 0; i < 20; i++){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Resources/arrays.txt", true))) {
                String result = Arrays.toString(TopologicalSorter.getSort(creater.getInput()).toArray());
                writer.write(result);
                writer.newLine();
            }
            catch (IOException e){
                System.out.println(i);
                throw new NullPointerException();
            }
        }
    }
}
