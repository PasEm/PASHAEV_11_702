package ru.itis;

import java.util.Scanner;

public class Ex38 {

    public static char convertDigitToLetter(long num){
        if  (num == 10) {
            return 'A';
        }
        if  (num == 11) {
            return 'B';
        }
        if  (num == 12) {
            return 'C';
        }
        if  (num == 13) {
            return 'D';
        }
        if  (num == 14) {
            return 'E';
        }
        if  (num == 15) {
            return 'F';
        }
        return (char) (num + '0');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String answer = "";
        while (n > 0){
            char number = convertDigitToLetter(n % 16);
            answer = number + answer;
            n /= 16;
        }
        System.out.println(answer);
    }
}
