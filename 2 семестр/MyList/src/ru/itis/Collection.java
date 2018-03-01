package ru.itis;

public interface Collection<T> extends Iterable<T>{
    void add(T element);
    void remove(T element);
    boolean contains(T element);
    int size();
}
