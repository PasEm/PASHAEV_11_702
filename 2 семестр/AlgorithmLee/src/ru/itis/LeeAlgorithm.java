package ru.itis;

import java.util.ArrayList;

public class LeeAlgorithm {
    private final int wall = -2;
    private final int free = -1;
    private int d = 0;
    private Point begin;
    private Point end;
    private boolean check;
    private int[][] net;

    public LeeAlgorithm(int[][] input, Point start, Point end){
        this.net = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++)
            System.arraycopy(input[i], 0, this.net[i], 0, input[0].length);
        this.begin = start;
        this.end = end;
    }

    private boolean checkCoordinates() {
        return begin.getX() >= 0 && begin.getX() < net.length && begin.getY() >= 0 && begin.getY() < net[0].length && end.getX() >= 0 && end.getX() < net.length && end.getY() >= 0 && end.getY() < net[0].length;
    }

    public boolean lee(){
        if (!checkCoordinates() || net[begin.getX()][begin.getY()] == wall || net[end.getX()][end.getY()] == wall)
            return false;
        this.check = false;
        while(net[end.getX()][end.getY()] == free && !check) {
            check = true;
            for (int i = 0; i < net.length; i++) {
                for (int j = 0; j < net[0].length; j++) {
                    if (net[i][j] == d)
                        updateWay(i, j);
                }
            }
            d++;
        }
        return net[end.getX()][end.getY()] != free;
    }

    private void updateWay(int x, int y){
        if (x + 1 < net.length && net[x + 1][y] == free) {
            net[x + 1][y] = d + 1;
            check = false;
        }
        if (x + 1 < net.length && y + 1 < net[0].length && net[x + 1][y + 1] == free) {
            check = false;
            net[x + 1][y + 1] = d + 1;
        }
        if (x + 1 < net.length && y - 1 >= 0 && net[x + 1][y - 1] == free) {
            net[x + 1][y - 1] = d + 1;
            check = false;
        }
        if (y + 1 < net[0].length && net[x][y + 1] == free) {
            net[x][y + 1] = d + 1;
            check = false;
        }
        if (y - 1 >= 0 && net[x][y - 1] == free) {
            check = false;
            net[x][y - 1] = d + 1;
        }
        if (x - 1 >= 0 && net[x - 1][y] == free) {
            check = false;
            net[x - 1][y] = d + 1;
        }
        if (x - 1 >= 0 && y + 1 < net[0].length && net[x - 1][y + 1] == free) {
            check = false;
            net[x - 1][y + 1] = d + 1;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && net[x - 1][y - 1] == free) {
            check = false;
            net[x - 1][y - 1] = d + 1;
        }
    }

    private Point findWay(int x, int y){
        if (x + 1 < net.length && net[x + 1][y] == d)
            return new Point(x + 1, y);
        if (x + 1 < net.length && y + 1 < net[0].length && net[x + 1][y + 1] == d)
            return new Point(x + 1, y + 1);
        if (x + 1 < net.length && y - 1 >= 0 && net[x + 1][y - 1] == d)
            return new Point(x + 1, y - 1);
        if (y + 1 < net[0].length && net[x][y + 1] == d)
            return new Point(x, y + 1);
        if (y - 1 >= 0 && net[x][y - 1] == d)
            return new Point(x, y - 1);
        if (x - 1 >= 0 && net[x - 1][y] == d)
            return new Point(x - 1, y);
        if (x - 1 >= 0 && y + 1 < net[0].length && net[x - 1][y + 1] == d)
            return new Point(x - 1, y + 1);
        return new Point(x - 1, y - 1);
    }

    public static ArrayList<Point> getWay(int[][] input, Point begin, Point end){
        LeeAlgorithm algorithm = new LeeAlgorithm(input, begin, end);
        if (!algorithm.lee())
            throw new IllegalArgumentException();
        ArrayList<Point> answer = new ArrayList<>();
        int currentX = end.getX();
        int currentY = end.getY();
        while(algorithm.d > 0) {
            algorithm.d--;
            Point next = algorithm.findWay(currentX, currentY);
            currentX = next.getX();
            currentY = next.getY();
            answer.add(0, next);
        }
        answer.add(end);
        return answer;
    }
}
