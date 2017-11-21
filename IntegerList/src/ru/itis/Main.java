package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUMBER_COUNT = 10;
        int numb[] = new int[NUMBER_COUNT];
        IntegerList list = new IntegerList();
        for (int i = 0; i < numb.length; i++){
            numb[i] = sc.nextInt();
            list.add(numb[i]);
        }
        IntegerList listSum = list.map(number -> {
            int sum = 0;
            int x = number;
            while(x > 0){
                sum += x % 10;
                x /= 10;
            }
            return sum;
        });
        IntegerList listOdd = list.filter(number -> { return (number % 2 == 1); });
        listSum.printNumbers();
        listOdd.printNumbers();
    }
}
