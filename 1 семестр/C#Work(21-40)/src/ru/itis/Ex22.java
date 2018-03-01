package ru.itis;

import java.util.Scanner;

public class Ex22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        int k = sc.nextInt();
        System.out.println(num1 + (k - 1) * (num2 - num1));
    }
}














