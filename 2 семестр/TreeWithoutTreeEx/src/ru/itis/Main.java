package ru.itis;

public class Main {

    public static void main(String[] args) {
        FinderMinRoot finderMinRoot = FinderMinRoot.getFinderMinRoot();
        System.out.println(finderMinRoot.findMinCountRoot("input/inputDefault.txt"));
    }
}
