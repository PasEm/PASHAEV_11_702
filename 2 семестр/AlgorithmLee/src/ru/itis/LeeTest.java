package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeeTest {
    private ArrayList<Point> answer;
    private ArrayList<Point> result;
    private Point begin;
    private Point end;
    private int[][] net;

    @Before
    public void setUp() {
        answer = new ArrayList<>();
        result = new ArrayList<>();
    }

    private void getInput(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder input = new StringBuilder();
            int height = -1;
            while (reader.ready()) {
                input.append(reader.readLine()).append(' ');
                height++;
            }
            String[] points = input.toString().trim().split(" ");
            this.begin = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
            this.end = new Point(Integer.parseInt(points[2]), Integer.parseInt(points[3]));
            int wide = (points.length - 4) / height;
            net = new int[height][wide];
            for (int i = 0; i < height; i++)
                for (int j = 0; j < wide; j++)
                    net[i][j] = Integer.parseInt(points[i * wide + j + 4]);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void test0() {
        int[][] grid = new int[3][5];
        grid[0][0] = 0;
        grid[0][1] = -2;
        grid[0][2] = -1;
        grid[0][3] = -2;
        grid[0][4] = -2;
        grid[1][0] = -2;
        grid[1][1] = -1;
        grid[1][2] = -2;
        grid[1][3] = -1;
        grid[1][4] = -2;
        grid[2][0] = -1;
        grid[2][1] = -2;
        grid[2][2] = -2;
        grid[2][3] = -2;
        grid[2][4] = -1;
        answer = LeeAlgorithm.getWay(grid, new Point(0, 0), new Point(2, 4));
        for (Point point : answer) {
            System.out.println(point.getX() + " " + point.getY());
        }
    }

    @Test
    public void test1() {
        getInput("InputTest/test1.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
        answer.add(new Point(3, 3));
        answer.add(new Point(4, 2));
        answer.add(new Point(5, 2));
        answer.add(new Point(6, 1));
        answer.add(new Point(5, 0));
        answer.add(new Point(4, 0));
        answer.add(new Point(3, 0));
        answer.add(new Point(2, 1));
        answer.add(new Point(1, 0));
        answer.add(new Point(0, 1));
        answer.add(new Point(0, 2));
        answer.add(new Point(1, 3));
        answer.add(new Point(0, 4));
        answer.add(new Point(1, 5));
        answer.add(new Point(2, 5));
        answer.add(new Point(3, 5));
        answer.add(new Point(4, 5));
        answer.add(new Point(5, 4));
        answer.add(new Point(6, 5));
        answer.add(new Point(6, 6));
        answer.add(new Point(5, 7));
        answer.add(new Point(6, 8));
        answer.add(new Point(5, 9));
        Assert.assertEquals(answer, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        getInput("InputTest/test2.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        getInput("InputTest/test3.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        getInput("InputTest/test4.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        getInput("InputTest/test5.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        getInput("InputTest/test6.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        getInput("InputTest/test7.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
    }

    @Test
    public void test8() {
        getInput("InputTest/test8.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
        answer.add(new Point(3, 3));
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test9() {
        getInput("InputTest/test9.txt");
        result = LeeAlgorithm.getWay(net, begin, end);
        answer.add(new Point(1, 1));
        answer.add(new Point(0, 2));
        answer.add(new Point(1, 3));
        answer.add(new Point(2, 3));
        Assert.assertEquals(answer, result);
    }
}
