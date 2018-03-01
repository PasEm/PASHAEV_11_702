package ru.itis;

import java.util.Scanner;

public class Ex25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double step = sc.nextDouble();
        double size = (num2 - num1) / step - 1;
        double sum = (num1 + num2) * size / 2;
        System.out.println("Кол-во элементов - " + (int) size + "; Сумма элементов - " + sum);
    }
}
