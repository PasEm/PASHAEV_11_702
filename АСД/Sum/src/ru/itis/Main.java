package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1, input2;
        input1 = sc.nextLine();
        input2 = sc.nextLine();
        int size = input1.length() > input2.length() ? input1.length() + 1: input2.length() + 1;
        int[] number1 = new int[size];
        int[] number2 = new int[size];
        int count, index1, index2;
        count = index1 = index2  = 0;
        for (int i = 0; i < size; i++) {
            number1[i] = (size - count > input1.length()) ? 0 : input1.charAt(index1++) - '0';
            number2[i] = (size - count++ > input2.length()) ? 0 : input2.charAt(index2++) - '0';
            //count++;
        }
        int[] number = new int[size];
        for (int i = 0; i < number.length; i++)
            number[i] = 0;
        for (int i = number.length - 1; i >= 1; i--){
            int num = number1[i] + number2[i];
            number[i] += num % 10;
            number[i - 1] += (number[i] / 10) + (num / 10);
            number[i] %= 10;
        }
        if (number[0] != 0)
            System.out.print(number[0]);
        for (int i = 1; i < number.length; i++)
            System.out.print(number[i]);
    }
}