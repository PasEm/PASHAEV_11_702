package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String number = sc.next();
	    int indexPoint = number.indexOf(',');
	    double numerator, fractional, power;
	    numerator = fractional = 0;
	    power = 1;
	    for (int i = 0; i < indexPoint; i++){
	        char x = number.charAt(i);
            numerator = numerator * 10 + ((int) x - '0');
        }
        for (int i = indexPoint + 1; i < number.length(); i++){
	        char x = number.charAt(i);
	        power *= 0.1d;
            fractional += ((int) x - '0') * power;
        }
        double answer = numerator + fractional;
        System.out.println(answer);
    }
}
