package ru.itis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        long[] factor = new long[input.length() + 1];
        factor[0] = 1;
        factor[1] = 1;
        for (int i = 2; i < factor.length; i++)
            factor[i] = factor[i - 1] * i;
        int[] number = new int[input.length() - 1];
        int size = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) > input.charAt(0))
                number[size++] = input.charAt(i) - '0';
        }
        long answer = 0;
        for (int i = 0; i < input.length(); i++) {
            int count = 0;
            for (int j = 0; j < size; j++){
                if (number[j] > (input.charAt(i) - '0'))
                    count++;
            }
            answer += factor[input.length() - i - 1] * count;
        }
        System.out.println(answer);
    }
}
