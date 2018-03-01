package ru.itis;

import java.util.Scanner;

public class Ex20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int left = (num1 / 100000 + num2 / 100000) % 10 + (num1 / 10000 % 10 + num2 / 10000 % 10) % 10 + (num1 / 1000 % 10 + num2 / 1000 % 10) % 10;
        int right = (num1 / 100 % 10 + num2 / 100 % 10) % 10 + (num1 / 10 % 10 + num2 / 10 % 10) % 10 + (num1 % 10 + num2 % 10) % 10;
        if (left == right) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
