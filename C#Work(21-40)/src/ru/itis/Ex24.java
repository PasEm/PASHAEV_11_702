package ru.itis;

import java.util.Scanner;

public class Ex24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int n = sc.nextInt();
        if ((n - f) % s == 0){
            System.out.println((n - f) / s + 1);
        } else{
            System.out.println(-1);
        }
    }
}
