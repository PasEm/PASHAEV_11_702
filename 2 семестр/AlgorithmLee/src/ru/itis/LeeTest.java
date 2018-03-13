package ru.itis;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LeeTest {
    private ArrayList<Point> answer;

    @Before
    public void setUp(){
        answer = new ArrayList<>();
    }

    @Test
    public void test1(){
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
        for (Point point : answer){
            System.out.println(point.getX() + " " + point.getY());
        }
    }
}
