package ru.itis;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private class Node{
        T value;
        Node next;
        Node(T value) {
            this.value = value;
        }
    }
    private class LinkedListIterator implements Iterator<T>{
        private int currentIndex;
        private Node currentNode;

        LinkedListIterator (){
            this.currentIndex = 0;
            this.currentNode = head;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            currentIndex++;
            T value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        int element = 0;
        Node answer = head;
        while(element != index){
            element++;
            answer = answer.next;
        }
        return answer.value;
    }

    @Override
    public void addToBegin(T object) {
        Node newNode = new Node(object);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    @Override
    public void remove(T element) {
        if (!contains(element))
            return;
        Node current = head;
        Node previous = null;
        while(!current.value.equals(element)){
            previous = current;
            current = current.next;
        }
        if (previous == null){
            head = current.next;
        } else {
            if (current == tail) {
                tail = previous;
                tail.next = null;
            } else {
                previous.next = current.next;
            }
        }
        this.size--;
    }

    @Override
    public boolean contains(T element) {
        Node current = head;
        while(!current.value.equals(element) && current != tail){
            current = current.next;
        }
        return current.value.equals(element);
    }

    public void printAll(){
        Node current = head;
        while(current != tail){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println(current.value);
    }

    public static <T extends Comparable<T>> LinkedList<T> merge(LinkedList<T> sort1, LinkedList<T> sort2){
        LinkedList<T> sorted = new LinkedList<>();
        Iterator<T> iterator1 = sort1.iterator();
        Iterator<T> iterator2 = sort2.iterator();
        T element1, element2;
        element1 = element2 = null;
        while(sorted.size != (sort1.size + sort2.size)) {
            element1 = (element1 == null) ? iterator1.hasNext() ? iterator1.next() : null : element1;
            element2 = (element2 == null) ? iterator2.hasNext() ? iterator2.next() : null : element2;
            if (element1 == null || element2 == null) {
                iterator1 = element1 == null ? iterator2 : iterator1;
                element1 = element1 == null ? element2 : element1;
                if (element1 != null) {
                    sorted.add(element1);
                    element1 = element2 = null;
                }
            } else {
                if (element1.compareTo(element2) < 0) {
                    sorted.add(element1);
                    element1 = null;
                } else {
                    sorted.add(element2);
                    element2 = null;
                }
            }
        }
        return sorted;
    }

    public LinkedList<T> sort() {
        LinkedList<T>[] stacks = (LinkedList<T>[]) new LinkedList[32];
        Node current = this.head;
        int count = -1;
        for (int i = 0; i < 32; i++)
            stacks[i] = new LinkedList<>();
        while(current != null){
            while(count > 0 && stacks[count].size == stacks[count - 1].size && stacks[count].size != 0) {
                stacks[count - 1] = merge(stacks[count], stacks[count - 1]);
                stacks[count--] = new LinkedList<>();
            }
            stacks[++count].add(current.value);
            current = current.next;
        }
        for (int i = count; i > 0; i--)
            stacks[i - 1] = merge(stacks[i], stacks[i - 1]);
        return stacks[0];
    }

    public void set(T value, int index){
        int size = 0;
        Node current = head;
        while(size != index){
            current = current.next;
            size++;
        }
        current.value = value;
    }

    public LinkedList<T> reverse(){
        LinkedList<T> result = new LinkedList<>();
        Node current = this.head;
        while(current != null) {
            result.addToBegin(current.value);
            current = current.next;
        }
        return result;
    }

}