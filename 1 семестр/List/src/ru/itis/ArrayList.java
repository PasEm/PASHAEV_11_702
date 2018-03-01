package ru.itis;

public class ArrayList {
    int array[];
    int count = 0;
    void addToEnd(int element){
        if (count + 1 > array.length){
                increase();
        }
        array[count] = element;
        count++;
    }
    void showList() {
        for (int i = 0; i < count; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    void increase(){
        int newarray[] = new int [array.length];
        for (int i = 0; i < array.length; i++){
            newarray[i] = array[i];
        }
        array = new int[array.length * 2];
        for (int i = 0; i < newarray.length; i++){
            array[i] = newarray[i];
        }
    }
    void deleteNumber(int index){
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
    void pushNumber(int index, int number){
        if (array.length-1 < count){
            increase();
        }
        for (int i = count-1; i >= index; i--){
            array[i+1] = array[i];
        }
        array[index] = number;
        count = index > count ? index + 1 : count+ 1;
    }
    void exit(){
        System.exit(0);
    }
    void init(int size){
        array = new int[size];
    }
}
