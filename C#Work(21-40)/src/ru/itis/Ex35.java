package ru.itis;

import java.util.Scanner;

public class Ex35 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int numbers[] = new int [k];
        int max = 0, iMax  = 0;
        while (n > 0) {
            numbers[n % k] ++;
            n /= k;
        }
        for (int i = numbers.length - 1; i >= 0; i--){
            if (max < numbers[i]){
                max = numbers[i];
                iMax = i;
            }
        }
        System.out.println(iMax);
    }
}
