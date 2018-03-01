package ru.itis;

import java.util.Scanner;

public class Ex6 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if ((data % 400 == 0) || ((data % 4 == 0) && (data % 100 != 0))){
            System.out.println(12 + "/0" + 9 + "/" + data);
        } else{
            System.out.println(13 + "/0" + 9 + "/" + data);
        }
    }
}
