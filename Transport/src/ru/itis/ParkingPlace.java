package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private static final int maxCount = 4;
    private int count;
    private String name;
    private Transport[] transportPlaces;
    private LocalTime beginTime;
    private LocalTime finishTime;
    public ParkingPlace(String name, LocalTime beginTime, LocalTime finishTime){
        this.name = name;
        this.beginTime = beginTime;
        this.finishTime = finishTime;
        transportPlaces = new Transport[maxCount];
        count = 0;
    }

    public String getName() {
        return name;
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
                System.out.println("Ваш(а) " + transport.getTransportName() + " заехал(а) на парковку " + this.getName() +  " с номером " + current);
            } else{
                System.out.println("Извините, парковка " + this.getName() + " переполнена, возвращайтесь в другое время");
            }
        } else {
            System.out.println("Парковка " + this.getName() + " не работает, возвращайтесь в другое время");
        }
    }

    public void takeTransport(Transport transport){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int current = 0;
            while (current < maxCount) {
                if (transportPlaces[current] == transport) {
                    transportPlaces[current] = null;
                    count--;
                    System.out.println("Ваш(а) " + transport.getTransportName() + " уехал(а) с парковки " + this.getName() + " под номером " + current);
                    break;
                }
                current++;
            }
            if (current == maxCount) {
                System.out.println("Данный транспорт не был припаркован");
            }
        } else {
            System.out.println("Парковка " + this.getName() + " не работает, возвращайтесь в другое время");
        }
    }
}
