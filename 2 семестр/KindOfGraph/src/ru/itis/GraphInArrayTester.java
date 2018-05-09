package ru.itis;

import org.junit.Assert;
import org.junit.Test;

public class GraphInArrayTester {
    private int[] answer;

    @Test
    public void test1(){
        int[] result = (new GraphInArray("Input\\input1.txt")).getGraph();
        answer = new int[12];
        answer[0] = 8;
        answer[1] = 10;
        answer[2] = -1;
        answer[3] = -1;
        answer[4] = -1;
        answer[5] = 11;
        answer[6] = -1;
        answer[7] = -1;
        answer[8] = 4;
        answer[9] = 3;
        answer[10] = 2;
        answer[11] = 7;
        for (int i = 0; i < answer.length; i++)
            Assert.assertEquals(answer[i], result[i]);
    }

    @Test
    public void test2(){
        int[] result = (new GraphInArray("Input\\input2.txt")).getGraph();
        answer = new int[9];
        answer[0] = -1;
        answer[1] = -1;
        answer[2] = -1;
        answer[3] = -1;
        answer[4] = 5;
        answer[5] = 0;
        answer[6] = 1;
        answer[7] = 2;
        answer[8] = 3;
        for (int i = 0; i < answer.length; i++)
            Assert.assertEquals(answer[i], result[i]);
    }

    @Test
    public void test3(){
        int[] result = (new GraphInArray("Input\\input3.txt")).getGraph();
        answer = new int[17];
        answer[0] = -1;
        answer[1] = -1;
        answer[2] = -1;
        answer[3] = -1;
        answer[4] = 10;
        answer[5] = -1;
        answer[6] = 12;
        answer[7] = -1;
        answer[8] = 14;
        answer[9] = -1;
        answer[10] = 9;
        answer[11] = 7;
        answer[12] = 6;
        answer[13] = 4;
        answer[14] = 1;
        answer[15] = 2;
        answer[16] = 4;
        for (int i = 0; i < answer.length; i++)
            Assert.assertEquals(answer[i], result[i]);
    }
}
