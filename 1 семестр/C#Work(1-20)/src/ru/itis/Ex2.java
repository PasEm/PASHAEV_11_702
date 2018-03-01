package ru.itis;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letter1 = sc.next().charAt(0);
        int pos1 = sc.nextInt();
        char letter2 = sc.next().charAt(0);
        int pos2 = sc.nextInt();
        if ((Math.abs(pos1 - pos2) == 1) && (letter1 == letter2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
