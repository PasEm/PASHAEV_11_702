package ru.itis;

public class Transport {
    protected String transportName;
    protected int oilConsumption;
    protected int consumption;

    public Transport(String transportName, int oilConsumption){
        this.transportName = transportName;
        this.oilConsumption = oilConsumption;
        this.consumption = 0;
    }

    public String getTransportName() {
        return transportName;
    }

    public int getOilConsumption() {
        return oilConsumption;
    }

    public int getConsumption() {
        return consumption;
    }

    public void move(int length){
        consumption += length * getOilConsumption();
        System.out.println("Ваш транспорт " + getTransportName() + " всего израсходовал " + getConsumption() + " литров топлива");
    }
}
