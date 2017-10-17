package ru.itis;

import java.util.Scanner;

public class Ex8 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double r1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double r2 = sc.nextDouble();
        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 -y1) * (y2 - y1));
        if (distance > r1 + r2){
            System.out.println("NO");
        } else{
            System.out.println("YES");
        }
    }
}
