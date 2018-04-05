package ru.itis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TreeBstTester {

    private ByteArrayOutputStream outputStream;
    private PrintStream console;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        console = System.out;
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
    }

    @After
    public void reset(){
        System.setOut(console);
    }

    @Test
    public void test1(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        String result = "1 2 3 4 4 5 5 6 6 7 8 10 ";
        tree.print();
        for (Integer number: array)
            Assert.assertTrue(tree.contains(number));
        Assert.assertEquals(result, outputStream.toString());
    }

    @Test
    public void test2(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        String result = "1 2 3 4 4 5 6 6 7 8 10 ";
        Assert.assertTrue(tree.remove(5));
        Assert.assertTrue(tree.isBst());
        tree.print();
        Assert.assertEquals(result, outputStream.toString());
    }

    @Test
    public void test3(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        String result = "1 2 3 4 4 5 5 7 8 10 ";
        Assert.assertTrue(tree.remove(6));
        Assert.assertTrue(tree.isBst());
        Assert.assertTrue(tree.remove(6));
        Assert.assertTrue(tree.isBst());
        tree.print();
        Assert.assertEquals(result, outputStream.toString());
    }

//    @Test
//    public void test4(){
//        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
//        TreeBstImpl<Integer> tree = new TreeBstImpl<Integer>(){
//
//             class Node {
//                private Integer value;
//                private Node left;
//                private Node right;
//
//                Node(Integer value) {
//                    this.value = value;
//                }
//            }
//
//            private Node root;
//
//            public void insert(Integer value) {
//                this.root = insert(root, value);
//            }
//
//            private Node insert(Node root, Integer value) {
//                if (root == null) {
//                    root = new Node(value);
//                } else if (value > root.value) {
//                    root.left = insert(root.left, value);
//                } else {
//                    root.right = insert(root.right, value);
//                }
//                return root;
//            }
//
//            public boolean isBst(){
//                return isBst(root);
//            }
//
//            private boolean isBst(Node root) {
//                if (root != null) {
//                    if ((root.left != null && root.value.compareTo(root.left.value) < 0) || (root.right != null && root.value.compareTo(root.right.value) >= 0)) {
//                        return false;
//                    } else {
//                        isBst(root.left);
//                        isBst(root.right);
//                    }
//                }
//                return true;
//            }
//        };
//        for (int anArray : array) {
//            tree.insert(anArray);
//        }
//        Assert.assertFalse(tree.isBst());
//    }

    @Test
    public void test5(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree1 = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree2 = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree3 = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree4 = new TreeBstImpl<>();
        TreeBstImpl<String> tree5 = new TreeBstImpl<>();
        for (Integer element: array){
            tree1.insert(element);
            tree2.insert(element);
            tree3.insert(element);
            tree5.insert(Integer.toString(element));
        }
        tree3.remove(2);
        Assert.assertTrue(tree1.equals(tree2));
        Assert.assertFalse(tree1.equals(tree3));
        Assert.assertFalse(tree1.equals(tree4));
        Assert.assertFalse(tree1.equals(tree5));
        Assert.assertFalse(tree2.equals(tree3));
        Assert.assertFalse(tree2.equals(tree4));
        Assert.assertFalse(tree2.equals(tree5));
        Assert.assertFalse(tree3.equals(tree4));
        Assert.assertFalse(tree3.equals(tree5));
        Assert.assertFalse(tree4.equals(tree5));
    }

    @Test
    public void test6(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (Integer element: array) {
            tree.insert(element);
        }
        tree.printByLevels();
        Assert.assertEquals(5, outputStream.toString().split(System.lineSeparator()).length);
    }

    @Test
    public void test7(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (Integer element: array) {
            tree.insert(element);
        }
        tree.printByLevels();
        Assert.assertEquals(6, outputStream.toString().split(System.lineSeparator()).length);
    }
}
