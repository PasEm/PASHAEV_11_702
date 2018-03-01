package ru.itis;

public class Ex27 {

    public static void main(String[] args) {
        int sumSquare = 0;
        int squareSum = (100 * 99) * (100 * 99) / 4;
        for (int i = 1; i < 101; i++){
            sumSquare += i * i;
        }
        System.out.println(sumSquare - squareSum);
    }
}
