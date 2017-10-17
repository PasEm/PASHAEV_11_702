package ru.itis;


import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inStRe = new InputStreamReader(System.in);
        char letter = (char) inStRe.read();
        int number = inStRe.read();
        switch (letter) {
            case 'A' :
                System.out.println((number % 2 == 0) ? "WHITE" : "BLACK");
                break;
            case 'B' :
                System.out.println((number % 2 != 0) ? "WHITE" : "BLACK");
                break;
            case 'C' :
                System.out.println((number % 2 == 0) ? "WHITE" : "BLACK");
                break;
            case 'D' :
                System.out.println((number % 2 != 0) ? "WHITE" : "BLACK");
                break;
            case 'E' :
                System.out.println((number % 2 == 0) ? "WHITE" : "BLACK");
                break;
            case 'F' :
                System.out.println((number % 2 != 0) ? "WHITE" : "BLACK");
                break;
            case 'G' :
                System.out.println((number % 2 == 0) ? "WHITE" : "BLACK");
                break;
            case 'H' :
                System.out.println((number % 2 != 0) ? "WHITE" : "BLACK");
                break;
        }
    }
}
