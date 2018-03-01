package ru.itis;

public class Participant {
    private String name;
    private char gender;

    public Participant(){
        this.name = null;
        this.gender = '\u0000';
    }

    public Participant(String name, char gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }
}
