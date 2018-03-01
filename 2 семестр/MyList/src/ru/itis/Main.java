package ru.itis;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(123);
        list.add(126);
        list.add(-123);
        list.add(22512);
        list.add(125);
        list.add(128);
        list.add(123);
        list.add(2212);
        list.add(12);
        list.add(1235);
        list.add(18);
        list.set(666, 3);
        list.printAll();
        list = list.sort();
        list.printAll();
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("reader");
        list3.add("writer");
        list3.add("add");
        list3.add("set");
        list3.add("dz");
        list3.printAll();
        list3.sort().printAll();
    }
}