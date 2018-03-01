package ru.itis;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CircleListTester {
    private CircleList list;

    @Before
    public void setUp(){
        this.list = CircleList.create("input.txt");
    }

    @Test
    public void testGender(){
        setUp();
        CircleList[] gender = list.gender();
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
        this.list.insert(new Participant("Andromeda", 'f'));
        String[] name = new String[11];
        Character[] gender = new Character[11];

    }
}
