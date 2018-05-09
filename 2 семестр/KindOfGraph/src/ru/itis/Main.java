package ru.itis;

public class Main {

    public static void main(String[] args) {
        GraphInArray graphInArray = new GraphInArray("Input\\inputDefault.txt");
        graphInArray.printArray();
        graphInArray.printGraph();
    }
}
