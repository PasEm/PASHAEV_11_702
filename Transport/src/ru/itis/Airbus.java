package ru.itis;

public class Airbus extends Transport{
    private int consumption;
    public Airbus(String name, int consumption){
        super(name);
        this.consumption = consumption;
    }

    public int getConsumption() {
        return consumption;
    }
}
