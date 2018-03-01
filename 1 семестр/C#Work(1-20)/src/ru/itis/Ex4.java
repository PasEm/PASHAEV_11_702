package ru.itis;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letter1 = sc.next().charAt(0);
        int pos1 = sc.nextInt();
        char letter2 = sc.next().charAt(0);
        int pos2 = sc.nextInt();
        if ((letter1 == letter2) || (pos1 == pos2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
