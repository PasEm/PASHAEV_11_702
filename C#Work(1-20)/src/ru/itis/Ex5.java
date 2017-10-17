package ru.itis;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inStRe = new InputStreamReader(System.in);
        char letter1 = (char) inStRe.read();
        int pos1 = inStRe.read() - '0';
        inStRe.read();
        char letter2 = (char) inStRe.read();
        int pos2 = inStRe.read() - '0';
        if (Math.abs(letter1 - letter2) == Math.abs(pos1 - pos2)){
            System.out.println("SAME");
        } else{
            System.out.println("NEIGHBOUR");
        }
    }
}
