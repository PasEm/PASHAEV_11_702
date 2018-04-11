package ru.itis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FinderMinRoot {
    private int n, k;
    private ArrayList<Root> tree;
    private final static FinderMinRoot instance;

    private FinderMinRoot(){
        this.n = this.k = 0;
        this.tree = new ArrayList<>();
    }

    public int findMinCountRoot(String fileName){
        readTree(fileName);
        int answer = 0;
        for (int i = 0; i < tree.size(); i++){
            if ((tree.get(i).getChildren() > 1 && k == 1) || (tree.get(i).getChildren() >= 0 && k < 1))
                throw new IllegalArgumentException();
            int count = tree.get(i).getChildren();
            if (count > k){
                while(count > 0){
                    answer += count / k;
                    count /= k;
                }
            }
        }
        return answer;
    }

    private void readTree(String fileName) {
        this.tree.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            if (reader.ready()) {
                String condition = reader.readLine();
                n = Integer.parseInt(condition.substring(0, condition.indexOf(' ')));
                k = Integer.parseInt(condition.substring(condition.indexOf(' ') + 1, condition.length()));
            }
            for (int index = 1; index < n; index++) {
                int inputRoot = Integer.parseInt(reader.readLine());
                if (tree.contains(new Root(inputRoot))) {
                    tree.get(tree.indexOf(new Root(inputRoot))).addChild();
                } else {
                    tree.add(new Root(inputRoot));
                    tree.get(tree.size() - 1).addChild();
                }
            }
            if (reader.ready() || k < 0 || n < 0)
                throw new IllegalArgumentException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        instance = new FinderMinRoot();
    }

    public static FinderMinRoot getFinderMinRoot(){
        return instance;
    }
}
