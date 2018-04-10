package ru.itis;

import java.util.ArrayList;
import java.util.Objects;

public class Root {
    private int parent;
    private ArrayList<Integer> children;

    public Root(int parent){
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void add(int child){
        children.add(child);
    }

    public ArrayList<Integer> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return parent == root.parent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent);
    }
}
