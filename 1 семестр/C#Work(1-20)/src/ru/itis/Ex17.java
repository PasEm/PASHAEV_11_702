package ru.itis;

import java.util.Scanner;

public class Ex17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num++;
        int left1 = (num / 100000) + (num / 1000 % 10) + (num / 10 % 10);
        int right1 = (num / 10000 % 10) + (num / 100 % 10) + (num % 10);
        num -= 2;
        int left2 = (num / 100000) + (num / 1000 % 10) + (num / 10 % 10);
        int right2 = (num / 10000 % 10) + (num / 100 % 10) + (num % 10);
        if ((Math.abs(left1 - right1) == 0) || (Math.abs(left2 - right2) == 0)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
