package ru.itis;

public class Main {

    public static void main(String[] args) {
        CircleList list = CircleList.create("input.txt");
        list.show();
        CircleList[] genders = list.gender();
        System.out.println();
        genders[0].show();
        System.out.println();
        genders[1].show();
        System.out.println();
        list.delete("Error");
        list.show();
        System.out.println();
        list.delete("Mark");
        list.show();
        System.out.println();
        list.sort("John");
        list.show();
        System.out.println();
        System.out.println(list.last(3).getName());
    }
}
