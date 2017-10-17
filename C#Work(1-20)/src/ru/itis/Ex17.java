package ru.itis;

import java.util.Scanner;

public class Ex17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int left = (num / 100000) + (num / 1000 % 10) + (num / 10 % 10);
        int right = (num / 10000 % 10) + (num / 100 % 10) + (num % 10);
        if (Math.abs(left - right) == 1){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
