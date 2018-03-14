package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SkyScraperTester {
    private ArrayList<Point> answer;
    private ArrayList<Point> result;
    private Point begin;
    private Point end;
    private int floorCount;
    private ArrayList<int[][]> net;

    @Before
    public void setUp(){
        answer = new ArrayList<>();
        result = new ArrayList<>();
        net = new ArrayList<>();
    }

    private void getInput(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder input = new StringBuilder();
            int floorSize = -1;
            while (reader.ready()) {
                input.append(reader.readLine()).append(' ');
                floorSize++;
            }
            String[] points = input.toString().trim().split(" ");
            this.begin = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]), Integer.parseInt(points[2]));
            this.end = new Point(Integer.parseInt(points[3]), Integer.parseInt(points[4]), Integer.parseInt(points[5]));
            this.floorCount = Integer.parseInt(points[6]);
            floorSize /= floorCount;
            for (int i = 0; i < floorCount; i++)
                net.add(new int[floorSize][floorSize]);
            for (int k = 0; k < floorCount; k++) {
                int netIndex = floorSize * floorSize * k;
                for (int i = 0; i < floorSize; i++)
                    for (int j = 0; j < floorSize; j++)
                        net.get(k)[i][j] = Integer.parseInt(points[netIndex + i * floorSize + j + 7]);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void test1(){
        ArrayList<int[][]> grid = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            grid.add(new int[3][3]);
        grid.get(0)[0][0] = -2;
        grid.get(0)[0][1] = -2;
        grid.get(0)[0][2] = -1;
        grid.get(0)[1][0] = -1;
        grid.get(0)[1][1] = -1;
        grid.get(0)[1][2] = -2;
        grid.get(0)[2][0] = -2;
        grid.get(0)[2][1] = -1;
        grid.get(0)[2][2] = -1;
        grid.get(1)[0][0] = -2;
        grid.get(1)[0][1] = -2;
        grid.get(1)[0][2] = -1;
        grid.get(1)[1][0] = 0;
        grid.get(1)[1][1] = -2;
        grid.get(1)[1][2] = -1;
        grid.get(1)[2][0] = -2;
        grid.get(1)[2][1] = -1;
        grid.get(1)[2][2] = -1;
        grid.get(2)[0][0] = -1;
        grid.get(2)[0][1] = -2;
        grid.get(2)[0][2] = -2;
        grid.get(2)[1][0] = -2;
        grid.get(2)[1][1] =-1 ;
        grid.get(2)[1][2] = -1;
        grid.get(2)[2][0] = -1;
        grid.get(2)[2][1] = -2;
        grid.get(2)[2][2] = -1;
        grid.get(3)[0][0] = -1;
        grid.get(3)[0][1] = -1;
        grid.get(3)[0][2] = -2;
        grid.get(3)[1][0] = -1;
        grid.get(3)[1][1] = -1;
        grid.get(3)[1][2] = -2;
        grid.get(3)[2][0] = -1;
        grid.get(3)[2][1] = -2;
        grid.get(3)[2][2] = -1;
        answer = SkyScraperWay.getWay(grid, new Point(1,1, 0), new Point(3,2, 0));
        for (Point point : answer){
            System.out.println(point.getFloor() + " " + point.getX() + " " + point.getY());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        ArrayList<int[][]> grid = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            grid.add(new int[3][3]);
        grid.get(0)[0][0] = -2;
        grid.get(0)[0][1] = -2;
        grid.get(0)[0][2] = -1;
        grid.get(0)[1][0] = -1;
        grid.get(0)[1][1] = -1;
        grid.get(0)[1][2] = -2;
        grid.get(0)[2][0] = -2;
        grid.get(0)[2][1] = -1;
        grid.get(0)[2][2] = -1;
        grid.get(1)[0][0] = -2;
        grid.get(1)[0][1] = -2;
        grid.get(1)[0][2] = -1;
        grid.get(1)[1][0] = 0;
        grid.get(1)[1][1] = -2;
        grid.get(1)[1][2] = -1;
        grid.get(1)[2][0] = -2;
        grid.get(1)[2][1] = -1;
        grid.get(1)[2][2] = -2;
        grid.get(2)[0][0] = -1;
        grid.get(2)[0][1] = -2;
        grid.get(2)[0][2] = -2;
        grid.get(2)[1][0] = -2;
        grid.get(2)[1][1] = -1;
        grid.get(2)[1][2] = -1;
        grid.get(2)[2][0] = -1;
        grid.get(2)[2][1] = -2;
        grid.get(2)[2][2] = -1;
        grid.get(3)[0][0] = -1;
        grid.get(3)[0][1] = -1;
        grid.get(3)[0][2] = -2;
        grid.get(3)[1][0] = -1;
        grid.get(3)[1][1] = -1;
        grid.get(3)[1][2] = -2;
        grid.get(3)[2][0] = -1;
        grid.get(3)[2][1] = -2;
        grid.get(3)[2][2] = -1;
        answer = SkyScraperWay.getWay(grid, new Point(1, 1, 0), new Point(3, 2, 0));
    }

    @Test
    public void test3(){
        getInput("InputTests/test1.txt");
        result = SkyScraperWay.getWay(net, begin, end);
        answer.add(new Point(0, 0, 0));
        answer.add(new Point(1, 0, 0));
        answer.add(new Point(1, 1, 0));
        answer.add(new Point(1, 2, 0));
        answer.add(new Point(2, 2, 0));
        answer.add(new Point(2, 2, 1));
        answer.add(new Point(2 , 2, 2));
        Assert.assertEquals(answer, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        getInput("InputTests/test2.txt");
        result = SkyScraperWay.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        getInput("InputTests/test3.txt");
        result = SkyScraperWay.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        getInput("InputTests/test4.txt");
        result = SkyScraperWay.getWay(net, begin, end);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        getInput("InputTests/test5.txt");
        result = SkyScraperWay.getWay(net, begin, end);
    }

    @Test
    public void test8() {
        getInput("InputTests/test6.txt");
        result = SkyScraperWay.getWay(net, begin, end);
        answer.add(new Point(0, 0, 0));
        Assert.assertEquals(answer, result);
    }
}
