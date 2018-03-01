package ru.itis;

import java.util.Scanner;

public class Ex29 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0;
        while (num > 0){
            answer += (num % 2 == 1) ? 1 : 0;
            num /= 2;
        }
        System.out.println(answer);
    }
}
