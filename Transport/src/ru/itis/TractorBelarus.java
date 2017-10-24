package ru.itis;

public class TractorBelarus extends Transport {
    private int potatoAmount;
    private int consumption;
    public TractorBelarus(String name, int consumption, int potatoAmount){
        super(name);
        this.consumption = consumption;
        this.potatoAmount = potatoAmount;
    }

    public int getConsumption() {
        return consumption;
    }

    public int getPotatoAmount() {
        return potatoAmount;
    }
}
