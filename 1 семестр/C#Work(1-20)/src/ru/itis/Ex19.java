package ru.itis;

import java.util.Scanner;

public class Ex19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = 0;
        if ((num1 / 1000 == num2 / 100 % 10) || (num1 / 1000 == num2 / 10 % 10) || (num1 / 1000 == num2 % 10)){
            count++;
        }
        if ((num1 / 100 % 10 == num2 / 1000) || (num1 / 100 % 10 == num2 / 10 % 10) || (num1 / 100 % 10 == num2 % 10)){
            count++;
        }
        if ((num1 / 10 % 10 == num2 / 1000) || (num1 / 10 % 10 == num2 / 100 % 10) || (num1 / 10 % 10 == num2 % 10)){
            count++;
        }
        if ((num1 % 10 == num2 / 1000) || (num1 % 10 == num2 / 10 % 10) || (num1 % 10 == num2 / 100 % 10)){
            count++;
        }
        System.out.println(count);
    }
}
