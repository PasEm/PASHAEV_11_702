package ru.itis;

import java.util.ArrayList;
import java.util.Objects;

public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {

    private class Node {
        private T value;
        private Node left;
        private Node right;
        private int height;

        Node(T value, int height) {
            this.value = value;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            boolean checkValue = (node.value != null) ? (value != null) && value.equals(node.value) : value == null;
            boolean checkLeft = (node.left != null) ? (left != null) && left.equals(node.left) : left == null;
            boolean checkRight = (node.right != null) ? (right != null) && right.equals(node.right) : right == null;
            return checkValue && checkRight && checkLeft;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);
        }
    }

    private Node root;
    private int height;

    public TreeBstImpl() {
        this.root = null;
        this.height = 0;
    }

    public void insert(T value) {
        this.root = insert(root, value, (root == null) ? 0 : root.height);
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    private Node insert(Node root, T value, int height) {
        if (root == null) {
            root = new Node(value, height);
        } else if (value.compareTo(root.value) <= 0) {
            root.left = insert(root.left, value, height + 1);
        } else {
            root.right = insert(root.right, value, height + 1);
        }
        this.height = (this.height < root.height) ? root.height : this.height;
        return root;
    }

    public boolean remove(T value) {
        Node previous = findRoot(null, this.root, value);
        if (previous == null && !this.root.value.equals(value))
            return false;
        Node current = (previous == null) ? this.root : (previous.left != null && previous.left.value.equals(value)) ? previous.left : previous.right;
        previous = (previous == null) ? this.root : previous;
        if (current.right == null){
            if (previous.left != null && current.value.equals(previous.left.value)){
                previous.left = current.left;
            } else {
                previous.right = current.left;
            }
        } else {
            Node minRightRoot = current;
            Node node = current.right;
            while(node.left != null){
                minRightRoot = node;
                node = node.left;
            }
            current.value = node.value;
            if (minRightRoot == current){
                current.right = minRightRoot.right.right;
            } else {
                minRightRoot.left = null;
            }
        }
        return true;
    }

    private Node findRoot(Node previous, Node current, T value){
        if (current != null) {
            if (current.value.equals(value))
                return previous;
            else {
                if (value.compareTo(current.value) <= 0) {
                    return findRoot(current, current.left, value);
                } else {
                    return findRoot(current, current.right, value);
                }
            }
        }
        return null;
    }

    public boolean contains(T value) {
        return contains(this.root, value);
    }

    private boolean contains(Node root, T value) {
        if (root != null) {
            if (root.value.equals(value))
                return true;
            else {
                if (value.compareTo(root.value) <= 0) {
                    return contains(root.left, value);
                } else {
                    return contains(root.right, value);
                }
            }
        }
        return false;
    }

    @Override
    public void printByLevels() {
        ArrayList<ArrayList<T>> tree = new ArrayList<>();
        addTreeByLevels(this.root, this.root.height, tree);
        for (int i = 0; i < tree.size(); i++){
            for (int j = 0; j < tree.get(i).size(); j++)
                if (tree.get(i).get(j) != null)
                    System.out.print(tree.get(i).get(j) + " ");
            System.out.println();
        }
        int space = (int) Math.pow(2, height + 1);
        for (int i = 0; i < tree.size(); i++){
            for (int j = 0; j < (space / 2 - 1); j++)
                System.out.print(" ");
            for (int j = 0; j < tree.get(i).size(); j++){
                if (tree.get(i).get(j) == null)
                    System.out.print(" ");
                else
                    System.out.print(tree.get(i).get(j));
                if (j != tree.get(i).size()) {
                    for (int k = 0; k < (space - 1); k++)
                        System.out.print(" ");
                }
            }
            System.out.println();
            space /= 2;
        }
    }

    private void addTreeByLevels(Node root, int height, ArrayList<ArrayList<T>> tree){
        if (height <= this.height) {
            if (tree.size() <= height)
                tree.add(new ArrayList<>());
            if (root == null) {
                tree.get(height).add(null);
            } else {
                tree.get(height).add(root.value);
                addTreeByLevels(root.left, height + 1, tree);
                addTreeByLevels(root.right, height + 1, tree);
            }
        }
    }

    @Override
    public boolean isBst() {
        return isBst(this.root);
    }

    private boolean isBst(Node root) {
        if (root != null) {
            if ((root.left != null && root.value.compareTo(root.left.value) < 0) || (root.right != null && root.value.compareTo(root.right.value) >= 0)) {
                return false;
            } else {
                isBst(root.left);
                isBst(root.right);
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeBstImpl)) return false;
        TreeBstImpl<?> treeBst = (TreeBstImpl<?>) o;
        return Objects.equals(root, treeBst.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}