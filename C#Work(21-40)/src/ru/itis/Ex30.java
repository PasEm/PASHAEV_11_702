package ru.itis;

import java.util.Scanner;

public class Ex30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num > 0){
            System.out.print(num % 2);
            num /= 2;
        }
    }
}
