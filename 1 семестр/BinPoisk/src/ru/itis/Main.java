package ru.itis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int find(int[] a, int left, int right, int x){
        int mid = left + (right - left) / 2;
        for (int i = left; i <= right; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        if (x < a[mid]) {
            return find(a, left, mid, x);
        } else {
            if (x > a[mid]){
                return find(a, mid, right, x);
            }
            else{
                if (a[mid] == x){
                    return mid;
                } else{
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(find(numbers, 0, numbers.length - 1, x));
    }
}
