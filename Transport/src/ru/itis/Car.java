package ru.itis;

public class Car extends Transport {
    private int consumption;
    public Car(String name, int consumption){
        super(name);
        this.consumption = consumption;
    }

    public int getConsumption() {
        return consumption;
    }
}
