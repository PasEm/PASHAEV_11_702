package ru.itis;

import java.util.Objects;

public class Root {
    private int parent;
    private int children;

    public Root(int parent){
        this.parent = parent;
        this.children = 0;
    }

    public void addChild(){
        children++;
    }

    public int getChildren() {
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
