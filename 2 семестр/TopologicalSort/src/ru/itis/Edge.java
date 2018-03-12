package ru.itis;

import java.util.Objects;

public class Edge {
    private int begin;
    private int end;

    public Edge(int begin, int end){
        this.end = end;
        this.begin = begin;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return begin == edge.begin && end == edge.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }
}
