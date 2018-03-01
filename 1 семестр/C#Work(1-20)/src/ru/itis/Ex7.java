package ru.itis;

import java.util.Scanner;

public class Ex7 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        if ((side1 > side2 - side3) && (side1 < side2 + side3) && (side2 > side1 - side3) && (side2 < side1 + side3) && (side3 < side1 + side2) && (side3 > side1 - side2)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
