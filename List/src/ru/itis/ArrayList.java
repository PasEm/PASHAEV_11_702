package ru.itis;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayList {
    int array[] = new int[100];
    int count = 0, firstsize = 0;
    void addToEnd(){
        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();
        if (count + 1 < array.length){
                increase();
        }
        array[count] = element;
        count++;
    }
    void showList() {
        for (int i = 0; i < (count > firstsize ? count : firstsize); i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    void increase(){
        array = Arrays.copyOf(array, array.length * 2);
    }
    void deleteNumber(){
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        array[index] = 0;
        for (int i = index; i < count; i++){
            int z = array[i];
            array[i] = array[i + 1];
            array[i + 1] = z;
        }
        count--;
    }
    void menu(){
        System.out.println("МЕНЮ:");
        System.out.println("1. Создать массив N размерности");
        System.out.println("2. Добавить число в конец массива");
        System.out.println("3. Удалить число из массива");
        System.out.println("4. Вставить число в массив");
        System.out.println("5. Вывести массив");
        System.out.println("6. Выход из меню");
    }
    void pushNumber(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int index = scanner.nextInt();
        if (array.length - 1 < index){
            increase();
        }
        for (int i = count-1; i >= index; i--){
            array[i+1] = array[i];
        }
        array[index] = number;
        count = index > count ? index + 1 : + 1;
    }
    void exit(){
        System.exit(0);
    }
    void init(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        firstsize = size;
    }
}
