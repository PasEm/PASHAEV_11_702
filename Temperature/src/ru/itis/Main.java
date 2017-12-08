package ru.itis;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\bloof\\Desktop\\PASHAEV_11_702\\Temperature\\src\\ru\\itis\\input.txt");
        Scanner sc = new Scanner(input);
        double[] monthTemp = new double[12];
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
        double yearTemp = 0;
        while(sc.hasNext()){
            String date = sc.next();
            String temp = sc.next();
            int month = ((int) date.charAt(3) - '0') * 10 + ((int) date.charAt(4) - '0');
            monthTemp[month - 1] += Double.parseDouble(temp);
        }
        for (int i = 0; i < 12; i++){
            yearTemp += monthTemp[i];
            monthTemp[i] /= days[i];
        }
        yearTemp /= 366;
        double minDif = Math.abs(monthTemp[0] - yearTemp);
        for (int i = 1; i < 12; i++){
            if (Math.abs(monthTemp[i] - yearTemp) < minDif){
                minDif = Math.abs(monthTemp[i] - yearTemp);
            }
        }
        for (int i = 0; i < 12; i++){
            if (Math.abs(monthTemp[i] - yearTemp) == minDif){
                System.out.println(i + 1);
            }
        }
    }
}