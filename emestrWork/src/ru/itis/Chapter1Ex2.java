package ru.itis;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class Chapter1Ex2 {

    public static char convertStringToChar(String letter){
        char answer = ' ';
        switch (letter){
            case "A" : answer = 'A';
                 break;
            case "B" : answer = 'B';
                break;
            case "C" : answer = 'C';
                break;
            case "D" : answer = 'D';
                break;
            case "E" : answer = 'E';
                break;
            case "F" : answer = 'F';
                break;
            case "G" : answer = 'G';
                break;
            case "H" : answer = 'H';
                break;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letter1 = sc.nextLine();
        int pos1 = sc.nextInt();
        String letter2 = sc.nextLine();
        int pos2 = sc.nextInt();
        char let1 = convertStringToChar(letter1);
        char let2 = convertStringToChar(letter2);
        System.out.println(pos1 + " " + pos2);
        System.out.println(let1);
        System.out.println(let2);
        if ((Math.abs(pos1 - pos2) == 1) && (Math.abs(let1 - let2) == 0)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
