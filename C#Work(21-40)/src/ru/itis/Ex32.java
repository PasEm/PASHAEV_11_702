package ru.itis;

import java.util.Scanner;

public class Ex32 {

    public static int convertKToDec(String num, int k){
        int power = 1;
        int answer = 0;
        for (int i = num.length() - 1; i >= 0; i--){
            int number = num.charAt(i) - '0';
            answer += power * (number % 10);
            power *= k;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kNum = sc.nextLine();
        String mNum = sc.nextLine();
        int k = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Число в системе счисления " + k + " стало " + convertKToDec(kNum, k));
        System.out.println("Число в системе счисления " + m + " стало " + convertKToDec(mNum, m));
    }
}
