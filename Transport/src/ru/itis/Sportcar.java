package ru.itis;

public class Sportcar extends Transport {
    private int consumption;
    public Sportcar(String name, int consumption){
        super(name);
        this.consumption = consumption;
    }

    public int getConsumption() {
        return consumption;
    }
}
