package ru.itis;

public class Main {

    public static void main(String[] args) {
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree1 = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree2 = new TreeBstImpl<>();
        TreeBstImpl<String> tree3 = new TreeBstImpl<>();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
            tree1.insert(array[i]);
            tree3.insert(Integer.toString(array[i]));
            tree2.insert(array[i]);
        }
        tree.print();
        System.out.println();
        tree.printByLevels();
        for (int i = 0; i < array.length; i++) {
            System.out.print(tree.contains(array[i]) + " ");
        }
        System.out.println();
        System.out.println(tree.contains(25));
        System.out.println(tree.contains(67));
        System.out.println(tree.isBst());
        System.out.println(tree.remove(5));
        tree.printByLevels();
        tree.print();
        System.out.println(tree.isBst());
        System.out.println(tree.equals(tree1) + " " + tree.equals(tree2) + " " + tree.equals(tree3) + " " + tree2.equals(tree3));
    }
}
