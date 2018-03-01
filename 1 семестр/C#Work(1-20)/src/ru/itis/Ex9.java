package ru.itis;

import java.util.Scanner;

public class Ex9 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a != 0){
            System.out.print(a + "x^2");
        }
        if (b != 0){
            if ((b > 0) && (a > 0)){
                System.out.print("+");
            }
            System.out.print(b + "x");
        }
        if (c != 0){
            if ((c > 0) && ((a > 0) || (b > 0))){
                System.out.print("+");
            }
            System.out.print(c);
        }
    }
}
