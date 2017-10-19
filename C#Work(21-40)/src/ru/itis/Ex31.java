package ru.itis;

import java.util.Scanner;

public class Ex31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binNum = sc.nextInt();
        int decNum = 0;
        int power = 1;
        int k = sc.nextInt();
        while (binNum > 0){
            decNum += power * (binNum % 10);
            power *= 2;
            binNum /= 10;
        }
        if (decNum % k == 0){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
