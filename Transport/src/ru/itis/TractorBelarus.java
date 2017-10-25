package ru.itis;

public class TractorBelarus extends Transport {

    private int potatoAmount;
    public TractorBelarus(String name, int oilConsumption, int potatoAmount){
        super(name,oilConsumption);
        this.potatoAmount = potatoAmount;
    }

    public int getPotatoAmount() {
        return potatoAmount;
    }
}
