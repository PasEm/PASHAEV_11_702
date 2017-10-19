package ru.itis;

import java.util.Scanner;

public class Ex39 {

    public static long convertHexToDec(char num){
        if  (num == 'A') {
            return 10;
        }
        if  (num == 'B') {
            return 11;
        }
        if  (num == 'C') {
            return 12;
        }
        if  (num == 'D') {
            return 13;
        }
        if  (num == 'E') {
            return 14;
        }
        if  (num == 'F') {
            return 15;
        }
        return (num - '0');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int k = sc.nextInt();
        long decNumber = 0, power = 1;
        for (int i = num.length() - 1; i >= 0; i--){
            decNumber += convertHexToDec(num.charAt(i)) * power;
            power *= 16;
        }
        if (k != 10) {
            String kNumber = "";
            while (decNumber > 0) {
                kNumber = (char) ((decNumber % k) + '0') + kNumber;
                decNumber /= k;
            }
            System.out.println(kNumber);
        } else{
            System.out.println(decNumber);
        }
    }
}
