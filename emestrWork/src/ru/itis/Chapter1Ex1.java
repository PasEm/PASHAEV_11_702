package ru.itis;

import java.util.Scanner;

public class Chapter1Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letter =  sc.nextLine();
        int number = sc.nextInt();
        String answer = "";
        switch (letter) {
            case "A" : answer = (number % 2 == 0) ? "WHITE" : "BLACK";
                       break;
            case "B" : answer = (number % 2 != 0) ? "WHITE" : "BLACK";
                       break;
            case "C" : answer = (number % 2 == 0) ? "WHITE" : "BLACK";
                       break;
            case "D" : answer = (number % 2 != 0) ? "WHITE" : "BLACK";
                       break;
            case "E" : answer = (number % 2 == 0) ? "WHITE" : "BLACK";
                       break;
            case "F" : answer = (number % 2 != 0) ? "WHITE" : "BLACK";
                       break;
            case "G" : answer = (number % 2 == 0) ? "WHITE" : "BLACK";
                       break;
            case "H" : answer = (number % 2 != 0) ? "WHITE" : "BLACK";
                       break;
        }
        System.out.println(answer);
    }
}
