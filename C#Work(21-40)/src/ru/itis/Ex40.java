package ru.itis;

import java.util.Scanner;

public class Ex40 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextInt();
        while (k > 0){
            if (k % 2 == 0){
                System.out.print(0);
            }
            k /= 2;
        }
    }
}
