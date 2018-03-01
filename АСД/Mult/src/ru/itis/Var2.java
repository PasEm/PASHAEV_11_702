package ru.itis;

import java.util.Scanner;

public class Var2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number1, number2;
        number1 = new StringBuilder(sc.nextLine()).reverse().toString();
        number2 = new StringBuilder(sc.nextLine()).reverse().toString();
        int[] answer = new int[number1.length() + number2.length()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = 0;
        for (int i = 0; i < number1.length(); i++){
            answer = sum(answer, number2, number1.charAt(i) - '0', i);
        }
        int start = answer[0] == 0 ? 1 : 0;
        for (int i = start; i < answer.length; i++)
            System.out.print(answer[i]);
        System.out.println();
    }

    public static int[] sum(int[] answer, String number, int number1, int shift){
        for (int i = 0; i < number.length(); i++){
            int num = number1 * (number.charAt(i) - '0');
            int index = answer.length - i - shift;
            answer[index - 1] += num;
            for (int j = index - 1; j >= ((index - 3 >= 0) ? index - 3 : 0); j--){
                if (j - 1 >= 0)
                    answer[j - 1] += answer[j] / 10;
                answer[j] %= 10;
            }
        }
        return answer;
    }
}
