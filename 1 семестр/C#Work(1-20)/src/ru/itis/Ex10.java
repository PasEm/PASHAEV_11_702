package ru.itis;

import java.util.Scanner;

public class Ex10 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b  = sc.nextDouble();
        double c = sc.nextDouble();
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0){
            System.out.println("Количество действительных корней: 0");
            System.out.println(-1);
        } else{
            if (discriminant == 0){
                System.out.println("Количество действительных корней: 1");
                System.out.println("Корень: " + (-b / (2 * a)));
            }
            if (discriminant > 0){
                System.out.println("Количество действителных корней: 2");
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Корни: " + x1 + " и " + x2);
            }
        }
    }
}
