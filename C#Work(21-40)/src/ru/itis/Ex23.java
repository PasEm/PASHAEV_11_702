package ru.itis;

import java.util.Scanner;

public class Ex23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println((num1 * 2 + (num2 - num1) * (n - 1)) * n / 2);
    }
}
