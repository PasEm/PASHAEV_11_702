package ru.itis;

import java.time.LocalTime;

public class Transport {
    private static final int maxCount = 4;
    protected String transportName;
    protected int oilConsumption;
    protected int consumption;
    private int count;
    private Transport[] transportPlaces;
    private LocalTime beginTime = LocalTime.parse("00:00:00");
    private LocalTime finishTime = LocalTime.parse("22:09:00");
    public Transport(String transportName, int oilConsumption){
        this.transportName = transportName;
        this.oilConsumption = oilConsumption;
        this.consumption = 0;
        transportPlaces = new Transport[maxCount];
        count = 0;
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

    public void parkTransport(Transport transport) {
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int current = 0;
            if (count < maxCount) {
                while (transportPlaces[current] != null){
                    current++;
                }
                count++;
                transportPlaces[current] = transport;
                System.out.println("Ваш(а) " + transport.getTransportName() + " заехал(а) на парковку с номером " + current);
            } else{
                System.out.println("Извините, парковка переполнен(а), возвращайтесь в другое время");
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
                    System.out.println("Ваш(а) " + transport.getTransportName() + " уехал(а) с парковки под номером " + current);
                    break;
                }
                current++;
            }
            if (current == maxCount) {
                System.out.println("Данный транспорт не был припаркован");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }

    public static void move(Transport transport, int length){
        transport.consumption += length * transport.getOilConsumption();
        System.out.println("Ваш транспорт " + transport.getTransportName() + " всего израсходовал " + transport.getConsumption() + " литров топлива");
    }
}
