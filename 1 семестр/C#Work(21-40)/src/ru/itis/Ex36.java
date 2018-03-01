package ru.itis;

import java.util.Scanner;

public class Ex36 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int maxLength = 0;
        int currentLength = 0;
        while (n > 0){
            if (n % 2 == 0){
                currentLength++;
            } else{
                maxLength = (currentLength > maxLength) ? currentLength : maxLength;
                currentLength = 0;
            }
            n /= 2;
        }
        System.out.println(maxLength);
    }
}
