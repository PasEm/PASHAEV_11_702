package ru.itis;

import java.util.Scanner;

public class Ex28 {

    public static double binPow (double n, int k){
        double res = 1;
        while(k > 0){
            if ((k & 1) == 1) {
                res *= n;
            }
            n *= n;
            k >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int k = sc.nextInt();
        System.out.println(binPow(n, k));
    }
}
