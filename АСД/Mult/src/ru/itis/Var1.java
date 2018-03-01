package ru.itis;

import java.util.Scanner;

public class Var1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1, input2;
        input1 = new StringBuilder(sc.nextLine()).reverse().toString();
        input2 = new StringBuilder(sc.nextLine()).reverse().toString();
        int[] number1 = new int[input1.length()];
        int[] number2 = new int[input2.length()];
        for (int i = 0; i < input1.length(); i++)
            number1[i] = input1.charAt(i) - '0';
        for (int i = 0; i < input2.length(); i++)
            number2[i] = input2.charAt(i) - '0';
        int[] number = new int[input1.length() + input2.length()];
        for (int i = 0; i < number.length; i++)
            number[i] = 0;
        for (int i = 0; i < number1.length; i++){
            long num = 0;
            for (int j = 0; j < number2.length || num != 0; j++) {
                num += number[i + j] + number1[i] * (j < number2.length ? number2[j] : 0);
                number[i + j] = (int) (num % 10);
                num /= 10;
            }
        }
        int size = (number[number.length - 1] == 0) ? number.length - 1 : number.length;
        for (int i = size - 1; i >= 0; i--)
            System.out.print(number[i]);
    }
}
