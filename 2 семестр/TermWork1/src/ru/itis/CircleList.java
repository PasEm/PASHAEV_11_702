package ru.itis;

import java.io.*;
import java.util.Iterator;

public class CircleList implements Iterable<Participant>{
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        Node next;
        Participant member;

        Node(Participant member){
            this.member = member;
        }
    }
    private class CircleListIterator implements Iterator<Participant>{
        private int currentIndex;
        private Node currentNode;

        CircleListIterator(){
            this.currentIndex = 0;
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Participant next() {
            Participant value = currentNode.member;
            this.currentNode = this.currentNode.next;
            this.currentIndex++;
            return value;
        }
    }

    public CircleList(){
        this.head = this.tail = null;
        this.size = 0;
    }

    public static CircleList create(String fileName){
        CircleList result = new CircleList();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName))))
        {
            while (reader.ready()){
                String input = reader.readLine();
                String name = input.substring(0, input.indexOf(' '));
                char gender = input.charAt(input.length() - 1);
                result.insert(new Participant(name, gender));
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Iterator<Participant> iterator() {
        return new CircleListIterator();
    }

    public void insert(Participant member){
        Node current = new Node(member);
        if (head == null){
            head = current;
            tail = current;
            tail.next = head;
        } else{
            tail.next = current;
            tail = current;
            tail.next = head;
        }
        this.size++;
    }

    public void delete(String name){
        if (!contain(name))
            return;
        Node previous = tail;
        Node current = head;
        while(!current.member.getName().equals(name) && current != tail){
            previous = current;
            current = current.next;
        }
        if (current == head){
            head = current.next;
            tail.next = head;
        } else {
            if (current == tail) {
                tail = previous;
                tail.next = head;
            } else if (current.member.getName().equals(name))
                previous.next = current.next;
        }
        this.size--;
    }

    public void show(){
        Node current = head;
        for (int i = 0; i < this.size; i++){
            System.out.println(current.member.getName() + ' ' + current.member.getGender());
            current = current.next;
        }
    }

    public Participant last(int k){
        int index = 1;
        Node current = head;
        while(size != 1){
            if (index % k == 0) {
                delete(current.member.getName());
                index = 0;
            }
            current = current.next;
            index++;
        }
        return head.member;
    }

    public CircleList[] gender(){
        CircleList[] result = {new CircleList(), new CircleList()};
        Node current = this.head;
        for (int i = 0; i < this.size; i++){
            if (current.member.getGender() == 'm')
                result[0].insert(current.member);
            else
                result[1].insert(current.member);
            current = current.next;
        }
        return result;
    }

    public void sort(String name){
        Node current = this.head;
        Node previous = null;
        int index = 0;
        for (int i = 0; i < this.size; i++){
            if (current.member.getName().equals(name)) {
                index = i;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (!current.member.getName().equals(name))
            return;
        CircleList[] stacks = new CircleList[32];
        int count = -1;
        for (int i = 0; i < 32; i++)
            stacks[i] = new CircleList();
        for (int i = index; i < this.size; i++){
            while(count > 0 && stacks[count].size == stacks[count - 1].size && stacks[count].size != 0) {
                stacks[count - 1] = merge(stacks[count], stacks[count - 1]);
                stacks[count--] = new CircleList();
            }
            stacks[++count].insert(current.member);
            current = current.next;
        }
        for (int i = count; i > 0; i--)
            stacks[i - 1] = merge(stacks[i], stacks[i - 1]);
        if (previous == null) {
            this.head = stacks[0].head;
            previous = this.head;
            current = stacks[0].head.next;
        } else {
            current = stacks[0].head;
        }
        for (int i = 0; i < stacks[0].size; i++){
            previous.next = current;
            previous = current;
            current = current.next;
        }
    }

    private static CircleList merge(CircleList sort1, CircleList sort2){
        CircleList sorted = new CircleList();
        Iterator<Participant> iterator1 = sort1.iterator();
        Iterator<Participant> iterator2 = sort2.iterator();
        Participant element1, element2;
        element1 = element2 = null;
        while(sorted.size != (sort1.size + sort2.size)) {
            element1 = (element1 == null) ? iterator1.hasNext() ? iterator1.next() : null : element1;
            element2 = (element2 == null) ? iterator2.hasNext() ? iterator2.next() : null : element2;
            if (element1 == null || element2 == null) {
                iterator1 = element1 == null ? iterator2 : iterator1;
                element1 = element1 == null ? element2 : element1;
                if (element1 != null) {
                    sorted.insert(element1);
                    element1 = element2 = null;
                }
            } else {
                if (element1.getName().compareTo(element2.getName()) < 0) {
                    sorted.insert(element1);
                    element1 = null;
                } else {
                    sorted.insert(element2);
                    element2 = null;
                }
            }
        }
        return sorted;
    }

    public boolean contain(String name){
        Node current = head;
        while(!current.member.getName().equals(name) && current != tail){
            current = current.next;
        }
        return (current.member.getName().equals(name));
    }

    public int size(){
        return size;
    }
}