package ru.itis;

import java.util.ArrayList;

public class Summator implements Runnable{
    private ThreadSum[] threadSums;
    private long totalSum;

    private class ThreadSum extends Thread {
        private ArrayList<Integer> array;

        private ThreadSum(ArrayList<Integer> array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.size(); i++)
                totalSum += array.get(i);
        }
    }

    public Summator(int count){
        threadSums = new ThreadSum[count];
        totalSum = 0;
    }

    public void createThreads(int[] array, int k){
        int currentSize = 0;
        for (int i = 0; i < k; i++){
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (i != k - 1){
                int size = array.length / k;
                for (int j = currentSize; j < currentSize + size; j++)
                    arrayList.add(array[j]);
                currentSize += size;
            } else {
                for (int j = currentSize; j < array.length; j++)
                    arrayList.add(array[j]);
            }
            threadSums[i] = new ThreadSum(arrayList);
        }
    }

    public Long getSum(){
        return totalSum;
    }

    @Override
    public void run() {
        for (int i = 0; i < threadSums.length; i++) {
            threadSums[i].start();
            try {
                threadSums[i].join();
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
