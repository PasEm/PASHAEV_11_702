package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private String place;
    private int count;
    private static final int maxCount = 2;
    private Car[] carPlaces;
    private LocalTime beginTime;
    private LocalTime finishTime;
    public ParkingPlace(String place, LocalTime beginTime, LocalTime finishTime){
        setPlace(place);
        this.carPlaces = new Car[maxCount];
        this.beginTime = beginTime;
        this.finishTime = finishTime;
        count = 0;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place){
        this.place = place;
    }
    public void parkCar(Car car) {
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int current = 0;
            if (count < maxCount) {
                while (carPlaces[current] != null){
                    current++;
                }
                carPlaces[current] = car;
                count++;
                System.out.println("Ваш(а) " + car.getColor() + " " + car.getModel() + " с номером " + car.getNumber() + " заехала на парковку " + getPlace() + " с номером " + current);
            } else{
                System.out.println("Извините, парковка переполнена, возвращайтесь в другое время");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }
    public void takeCar(Car car){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int current = 0;
            while (current < maxCount) {
                if (carPlaces[current] == car) {
                    carPlaces[current] = null;
                    count--;
                    System.out.println("Ваш(а) " + car.getColor() + " " + car.getModel() + " с номером " + car.getNumber() + " уехала с парковки " + getPlace() + " под номером " + current);
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
}
