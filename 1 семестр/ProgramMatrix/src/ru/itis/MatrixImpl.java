package ru.itis;

import java.util.HashMap;

public class MatrixImpl implements Matrix{
    private HashMap<String, Integer> matrix;

    public MatrixImpl(){
        matrix = new HashMap<>();
    }

    @Override
    public void set(int i, int j, int value) {
        String index = "" + i + '/' + j;
        if (matrix.containsKey(index)){
            matrix.remove(index);
        }
        matrix.put(index, value);
    }

    @Override
    public int get(int i, int j) {
        String index = "" + i + '/' + j;
        if (matrix.containsKey(index)) {
            return matrix.get(index);
        } else{
            return 0;
        }
    }
}
