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

    public static void move(Transport transport, int length){
        transport.consumption += length * transport.getOilConsumption();
        System.out.println("Ваш транспорт " + transport.getTransportName() + " всего израсходовал " + transport.getConsumption() + " литров топлива");
    }

    public void cartoshkaTime(){
        if (this.getClass() == TractorBelarus.class){
            System.out.println("У вас " + TractorBelarus.getPotatoAmount() + " кг картошки" );
        } else {
            System.out.println("У вас нет транспорта \"Трактор-Беларусь\"");
        }
    }
}
