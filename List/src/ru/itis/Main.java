package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        while (command != 6){
            list.menu();
            command = scanner.nextInt();
            if (command == 1){
                list.init();
            }
            if (command == 2){
                list.addToEnd();
            }
            if (command == 3){
                list.deleteNumber();
            }
            if (command == 4){
                list.pushNumber();
            }
            if (command == 5){
                list.showList();
            }
            if (command == 6){
                list.exit();
            }
        }
    }
}
