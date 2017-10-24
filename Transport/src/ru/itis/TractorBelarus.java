package ru.itis;

public class TractorBelarus extends Transport {
    private int potatoAmount;
    public TractorBelarus(String name, int potatoAmount){
        super(name);
        this.potatoAmount = potatoAmount;
    }

    public int getPotatoAmount() {
        return potatoAmount;
    }
}
