package ru.itis;

import java.time.LocalTime;

public class Transport {
    protected String transportName;
    protected int oilConsumption;
    private int count;
    private static final int maxCount = 4;
    private Transport[] transportPlaces = new Transport[maxCount];
    private LocalTime beginTime = LocalTime.parse("00:00:00");
    private LocalTime finishTime = LocalTime.parse("22:00:00");
    public Transport(String transportName){
        this.transportName = transportName;
        this.oilConsumption = 0;
        count = 0;
    }

    public String getTransportName() {
        return transportName;
    }

    public int getOilConsumption() {
        return oilConsumption;
    }

    public void parkTransport(Transport transport) {
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int current = 0;
            if (count < maxCount) {
                while (transportPlaces[current] != null){
                    current++;
                }
                count++;
                transportPlaces[current] = transport;
                System.out.println("Ваш(а) " + transport.getTransportName() + " заехала на парковку с номером " + current);
            } else{
                System.out.println("Извините, парковка переполнена, возвращайтесь в другое время");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }

    public void takeTransport(Transport transport){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int current = 0;
            while (current < maxCount) {
                if (transportPlaces[current] == transport) {
                    transportPlaces[current] = null;
                    count--;
                    System.out.println("Ваш(а) " + transport.getTransportName() + " уехала с парковки под номером " + current);
                    break;
                }
                current++;
            }
            if (current == maxCount) {
                System.out.println("Данный автомобиль не был припаркован");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }

    /**public void move(Class c, int length){
      *  this.oilConsumption += length * c.consumption;
      *  System.out.println("Ваш транспорт израсходовал " + oilConsumption + " литров топлива");
    }
     Требует доработки*/
}
