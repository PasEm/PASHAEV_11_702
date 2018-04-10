package ru.itis;

import org.junit.Assert;
import org.junit.Test;

public class FindMinRootsTester {
    private FinderMinRoot finder = FinderMinRoot.getFinderMinRoot();

    @Test
    public void test1(){
        int answer = 2;
        int result = finder.findMinCountRoot("input/inputDefault.txt");
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test2(){
        int answer = 4;
        int result = finder.findMinCountRoot("input/input1.txt");
        Assert.assertEquals(answer, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3(){
       finder.findMinCountRoot("input/input2.txt");
    }

    @Test
    public void test4(){
        int answer = 0;
        int result = finder.findMinCountRoot("input/input3.txt");
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test5(){
        int answer = 0;
        int result = finder.findMinCountRoot("input/input4.txt");
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test6(){
        int answer = 3;
        int result = finder.findMinCountRoot("input/input5.txt");
        Assert.assertEquals(answer, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7(){
        finder.findMinCountRoot("input/input7.txt");
    }

    @Test
    public void test8(){
        int answer = 0;
        int result = finder.findMinCountRoot("input/input8.txt");
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test9(){
        int answer = 0;
        int result = finder.findMinCountRoot("input/input9.txt");
        Assert.assertEquals(answer, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test10(){
        finder.findMinCountRoot("input/input10.txt");
    }

    @Test
    public void test11(){
        int answer = 2;
        int result = finder.findMinCountRoot("input/input11.txt");
        Assert.assertEquals(answer, result);
    }
}
