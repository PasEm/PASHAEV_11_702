package ru.itis;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalTester {
    private ArrayList<Integer> answer;

    @Before
    public void setUp(){
        answer = new ArrayList<>();
    }

    @Test
    public void test1(){
        Edge[] input = new Edge[9];
        input[0] = new Edge(3,8);
        input[1] = new Edge(3,10);
        input[2] = new Edge(5,11);
        input[3] = new Edge(7,11);
        input[4] = new Edge(7,8);
        input[5] = new Edge(8,9);
        input[6] = new Edge(11,2);
        input[7] = new Edge(11,9);
        input[8] = new Edge(11,10);
        answer = TopologicalSorter.getSort(input);
        System.out.println(Arrays.toString(answer.toArray()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        Edge[] input = new Edge[3];
        input[0] = new Edge(3,8);
        input[1] = new Edge(8,5);
        input[2] = new Edge(5,3);
        answer = TopologicalSorter.getSort(input);
    }

    @Test
    public void test3(){
        Edge[] input = new Edge[4];
        input[0] = new Edge(1,4);
        input[1] = new Edge(4,2);
        input[2] = new Edge(4,3);
        input[3] = new Edge(3,2);
        answer = TopologicalSorter.getSort(input);
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
