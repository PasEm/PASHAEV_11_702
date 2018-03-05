package ru.itis;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

public class CircleListTester {
    private LinkedList<Participant> list;

    @Before
    public void setUp(){
        this.list = new LinkedList<>();
        list.add(new Participant("Ivan", 'm'));
        list.add(new Participant("Mary", 'f'));
        list.add(new Participant("Anna", 'f'));
        list.add(new Participant("Lora", 'f'));
        list.add(new Participant("John", 'm'));
        list.add(new Participant("Ivan", 'm'));
        list.add(new Participant("Jovanni", 'm'));
        list.add(new Participant("Mark", 'm'));
        list.add(new Participant("Aria", 'f'));
        list.add(new Participant("Bella", 'f'));
    }

    @Test
    public void testCreate(){
        setUp();
        CircleList circleList = CircleList.create("input.txt");
        int index = 0;
        for (Participant member: circleList){
            Assert.assertEquals(list.get(index).getName(), member.getName());
            Assert.assertEquals(list.get(index++).getGender(), member.getGender());
        }
    }

    @Test
    public void testGender(){
        CircleList[] gender = CircleList.create("input.txt").gender();
        String[] genderM = new String[gender[0].size()];
        String[] genderF = new String[gender[1].size()];
        int i = 0;
        for(Participant member: gender[0])
            genderM[i++] = member.getName();
        i = 0;
        for(Participant member: gender[1])
            genderF[i++] = member.getName();
        String[] male = new String[5];
        String[] female = new String[5];
        male[0] = "Ivan";
        male[1] = "John";
        male[2] = "Ivan";
        male[3] = "Jovanni";
        male[4] = "Mark";
        female[0] = "Mary";
        female[1] = "Anna";
        female[2] = "Lora";
        female[3] = "Aria";
        female[4] = "Bella";
        Assert.assertArrayEquals(male, genderM);
        Assert.assertArrayEquals(female, genderF);
    }

    @Test
    public void testInsert(){
        setUp();
        CircleList circleList = CircleList.create("input.txt");
        circleList.insert(new Participant("Andromeda", 'f'));
        this.list.add(new Participant("Andromeda", 'f'));
        int index = 0;
        for (Participant member: circleList){
            Assert.assertEquals(list.get(index).getName(), member.getName());
            Assert.assertEquals(list.get(index++).getGender(), member.getGender());
        }
    }

    @Test
    public void testDelete() {
        setUp();
        this.list.remove(7);
        CircleList circleList = CircleList.create("input.txt");
        circleList.delete("Mark");
        int index = 0;
        for (Participant member : circleList) {
            Assert.assertEquals(list.get(index).getName(), member.getName());
            Assert.assertEquals(list.get(index++).getGender(), member.getGender());
        }
    }

    @Test
    public void testDeleteSizeZero(){
        LinkedList<Participant> result = new LinkedList<>();
        CircleList circleList = new CircleList();
        circleList.insert(new Participant("Boreal", 'm'));
        circleList.delete("Boreal");
        Assert.assertEquals(result.size(), circleList.size());
        circleList.delete("Andromeda");
        Assert.assertEquals(result.size(), circleList.size());
        int index = 0;
        for (Participant member: circleList){
            Assert.assertEquals(result.get(index).getGender(), member.getGender());
            Assert.assertEquals(result.get(index++).getName(), member.getName());
        }
    }

    @Test
    public void testShow(){
        setUp();
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream console = System.out;
        PrintStream outputStream = new PrintStream(arrayOutputStream);
        System.setOut(outputStream);
        CircleList circleList = CircleList.create("input.txt");
        circleList.show();
        String[] output = arrayOutputStream.toString().trim().split(System.lineSeparator());
        for (int i = 0; i <this.list.size(); i++){
            Assert.assertEquals(this.list.get(i).getName() + ' ' + this.list.get(i).getGender(), output[i]);
        }
        System.setOut(console);
    }

    @Test
    public void testLast(){
        CircleList circleList = CircleList.create("input.txt");
        Participant winner = circleList.last(3);
        Assert.assertEquals("Lora", winner.getName());
        Assert.assertEquals('f', winner.getGender());
        winner = circleList.last(5);
        Assert.assertEquals("Lora", winner.getName());
        Assert.assertEquals('f', winner.getGender());
    }


    @Test
    public void testContain(){
        CircleList circleList = CircleList.create("input.txt");
        Assert.assertTrue(circleList.contain("Mark"));
        Assert.assertFalse(circleList.contain("Boreal"));
    }

    @Test
    public void testSort(){
        setUp();
        list.set(4, new Participant("Aria", 'f'));
        list.set(5, new Participant("Bella", 'f'));
        list.set(6, new Participant("Ivan", 'm'));
        list.set(7, new Participant("John", 'm'));
        list.set(8, new Participant("Jovanni", 'm'));
        list.set(9, new Participant("Mark", 'm'));
        CircleList circleList = CircleList.create("input.txt");
        circleList.sort("John");
        int index = 0;
        for (Participant member: circleList){
            Assert.assertEquals(list.get(index).getName(), member.getName());
            Assert.assertEquals(list.get(index++).getGender(), member.getGender());
        }
    }

    @Test
    public void testSize(){
        setUp();
        CircleList circleList = CircleList.create("input.txt");
        Assert.assertEquals(this.list.size(), circleList.size());
    }
}