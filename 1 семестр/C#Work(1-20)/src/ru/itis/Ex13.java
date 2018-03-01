package ru.itis;

import java.util.Scanner;

public class Ex13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if ((num / 100000 == num % 10) && (num / 10000 % 10 == num % 100 / 10) && (num / 1000 % 10 == num % 1000 / 100)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
