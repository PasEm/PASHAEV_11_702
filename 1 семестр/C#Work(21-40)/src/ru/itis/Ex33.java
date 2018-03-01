package ru.itis;

import java.util.Scanner;

public class Ex33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        while(n > 0){
            sum += n % k;
            n /= k;
        }
        System.out.println(sum);
    }
}
