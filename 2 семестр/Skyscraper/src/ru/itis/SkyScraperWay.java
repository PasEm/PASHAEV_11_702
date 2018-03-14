package ru.itis;

import java.util.ArrayList;

public class SkyScraperWay {
    private final int free = -1;
    private int size;
    private int d = 0;
    private Point end;
    private Point begin;
    private boolean check;
    private ArrayList<int[][]> net;

    public SkyScraperWay(ArrayList<int[][]> input, Point begin, Point end){
        this.size = input.get(0).length;
        this.net = new ArrayList<>();
        this.net.addAll(input);
        this.end = end;
        this.begin = begin;
    }

    private boolean checkCoordinates() {
        return begin.getFloor() >= 0 && begin.getFloor() < net.size() && end.getFloor() >= 0 && end.getFloor() < net.size() && begin.getX() >= 0 && begin.getX() < net.get(0).length && begin.getY() >= 0 && begin.getY() < net.get(0)[0].length && end.getX() >= 0 && end.getX() < net.get(0).length && end.getY() >= 0 && end.getY() < net.get(0)[0].length;
    }

    public boolean lee(){
        final int wall = -2;
        if (!checkCoordinates() || net.get(begin.getFloor())[begin.getX()][begin.getY()] == wall || net.get(end.getFloor())[end.getX()][end.getY()] == wall)
            return false;
        this.check = false;
        while(net.get(end.getFloor())[end.getX()][end.getY()] == free && !check) {
            check = true;
            for (int k = 0; k < net.size(); k++)
                for (int i = 0; i < size; i++)
                    for (int j = 0; j < size; j++) {
                        if (net.get(k)[i][j] == d)
                            updateWay(k, i, j);
                    }
            d++;
        }
        return net.get(end.getFloor())[end.getX()][end.getY()] != free;
    }

    private void updateWay(int floor, int x, int y){
        if (x + 1 < size && net.get(floor)[x + 1][y] == free) {
            net.get(floor)[x + 1][y] = d + 1;
            check = false;
        }
        if (y + 1 < size && net.get(floor)[x][y + 1] == free) {
            net.get(floor)[x][y + 1] = d + 1;
            check = false;
        }
        if (y - 1 >= 0 && net.get(floor)[x][y - 1] == free) {
            check = false;
            net.get(floor)[x][y - 1] = d + 1;
        }
        if (x - 1 >= 0 && net.get(floor)[x - 1][y] == free) {
            check = false;
            net.get(floor)[x - 1][y] = d + 1;
        }
        if (floor - 1 >= 0 && net.get(floor - 1)[x][y] == free){
            check = false;
            net.get(floor - 1)[x][y] = d + 1;
        }
        if (floor + 1 < net.size() && net.get(floor + 1)[x][y] == free){
            check = false;
            net.get(floor + 1)[x][y] = d + 1;
        }
    }

    private Point findWay(int floor, int x, int y){
        if (x + 1 < size && net.get(floor)[x + 1][y] == d)
            return new Point(floor,x + 1, y);
        if (y + 1 < size && net.get(floor)[x][y + 1] == d)
            return new Point(floor, x, y + 1);
        if (y - 1 >= 0 && net.get(floor)[x][y - 1] == d)
            return new Point(floor, x, y - 1);
        if (x - 1 >= 0 && net.get(floor)[x - 1][y] == d)
            return new Point(floor, x - 1, y);
        if (floor - 1 >= 0 && net.get(floor -1)[x][y] == d)
            return new Point(floor - 1, x, y);
        return new Point(floor + 1, x, y);
    }

    public static ArrayList<Point> getWay(ArrayList<int[][]> input, Point begin, Point end){
        SkyScraperWay algorithm = new SkyScraperWay(input, begin, end);
        if (!algorithm.lee())
            throw new IllegalArgumentException();
        ArrayList<Point> answer = new ArrayList<>();
        int currentX = end.getX();
        int currentY = end.getY();
        int currentFloor = end.getFloor();
        while(algorithm.d > 0) {
            algorithm.d--;
            Point next = algorithm.findWay(currentFloor, currentX, currentY);
            currentX = next.getX();
            currentY = next.getY();
            currentFloor = next.getFloor();
            answer.add(0, next);
        }
        answer.add(end);
        return answer;
    }
}
