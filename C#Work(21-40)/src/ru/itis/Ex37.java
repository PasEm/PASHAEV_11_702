package ru.itis;

import java.util.Scanner;

public class Ex37 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int currentSize = 0, maxSize = 0;
        int last = 11;
        while (n > 0) {
            if (n % k <= last) {
                currentSize++;
            } else {
                maxSize = (maxSize < currentSize) ? currentSize : maxSize;
                currentSize = 1;
            }
            last = n % k;
            n /= k;
        }
        maxSize = (maxSize < currentSize) ? currentSize : maxSize;
        System.out.println(maxSize);
    }
}
