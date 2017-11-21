package ru.itis;

public class IntegerList {
    private final int NUMBER_COUNT = 10;
    private int count;
    private int[] numbers;

    public IntegerList() {
        numbers = new int[NUMBER_COUNT];
        count = 0;
    }

    public void add(int number){
        numbers[count] = number;
        count++;
    }

    public IntegerList filter(Predicate predicate){
        IntegerList result = new IntegerList();
        for (int i = 0; i < count; i++){
            if (predicate.test(numbers[i])) {
                result.add(numbers[i]);
            }
        }
        return result;
    }

    public IntegerList map(Function function){
        IntegerList result = new IntegerList();
        for (int i = 0; i < count; i++){
            result.add(numbers[i]);
            result.numbers[i] = function.apply(result.numbers[i]);
        }
        return result;
    }

    public void printNumbers(){
        for (int i = 0; i < count; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

}
