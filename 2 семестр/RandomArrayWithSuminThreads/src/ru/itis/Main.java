package ru.itis;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        long threadSum, realSum = 0;
        Summator summator = new Summator(k);
        Random randomizer = new Random();
        long realTime = System.nanoTime();
        for (int i = 0; i < n; i++){
            array[i] = randomizer.nextInt(1000);
            realSum += array[i];
        }
        realTime = System.nanoTime() - realTime;
        summator.createThreads(array, k);
        Thread thread = new Thread(summator);
        long threadTime = System.nanoTime();
        thread.start();
        try {
            thread.join();
            threadSum = summator.getSum();
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        threadTime = System.nanoTime() - threadTime;
        System.out.println(threadSum + ", time in nano: " + threadTime);
        System.out.println(realSum + ", time in nano: " + realTime);
        System.out.println("Difference in time(real / thread): " + (double) threadTime / realTime);
    }
}
