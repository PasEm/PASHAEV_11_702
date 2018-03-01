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

    public void cartoshkaTime(){
        System.out.println("У вас, " + getTransportName() + ", " +  getPotatoAmount() + " кг картошки" );
    }
}
