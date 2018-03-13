package ru.itis;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SkyScraperTester {
    private ArrayList<Point> answer;

    @Before
    public void setUP(){
        answer = new ArrayList<>();
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
}
