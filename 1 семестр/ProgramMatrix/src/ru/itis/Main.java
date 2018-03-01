package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File input = new File("input.txt");
        Scanner sc;
        try {
            sc = new Scanner(input);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        MatrixImpl matrix = new MatrixImpl();
        while (sc.hasNext()) {
            int i, j, value;
            i = Integer.parseInt(sc.next());
            j = Integer.parseInt(sc.next());
            value = Integer.parseInt(sc.next());
            matrix.set(i, j, value);
        }
        System.out.println(matrix.get(1, 2));
    }
}
