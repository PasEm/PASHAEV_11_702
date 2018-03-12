package ru.itis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    public static void writeData(int size, long iterations, long time){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Resources/output.txt", true))){
            writer.write(String.valueOf(size) + ' ' + iterations + ' ' + time + '\n');
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }
}
