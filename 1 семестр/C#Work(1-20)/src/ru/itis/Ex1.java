package ru.itis;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        //InputStreamReader inStRe = new InputStreamReader(System.in);
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        int number = sc.nextInt();
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
