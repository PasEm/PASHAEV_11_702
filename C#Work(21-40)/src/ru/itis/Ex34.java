package ru.itis;

import java.util.Scanner;

public class Ex34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int pros = 1;
        while(n > 0){
            pros *= n % k;
            n /= k;
        }
        System.out.println(pros);
    }
}
