package ru.itis;

public class Tank extends Transport {
    private int consumption;
    public Tank(String name, int consumption){
        super(name);
        this.consumption = consumption;
    }

    public int getConsumption() {
        return consumption;
    }
}
