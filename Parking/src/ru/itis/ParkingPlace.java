package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private String place;
    private int count = 0;
    private int maxCount = 2;
    private Car[] carPlaces = new Car[maxCount];
    private LocalTime beginTime = LocalTime.parse("02:00:00");
    private LocalTime finishTime = LocalTime.parse("03:00:00");
    public ParkingPlace(String place){
        setPlace(place);
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
            count++;
            if (count < maxCount) {
                while (carPlaces[current] != null){
                    current++;
                }
                carPlaces[current] = car;
                car.setParkposition(this);
                System.out.println(car.getColor() + " " + car.getModel() + " с номером " + car.getNumber() + " заехала на парковку с номером " + getPlace());
            } else{
                System.out.println("Парковка переполнена, возвращайтесь в другое время");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }
    public void takeCar(Car car){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)){
            int current = 0;
            while (carPlaces[current] != car) {
                current++;
            }
            carPlaces[current] = null;
            car.setParkposition(null);
            count--;
            System.out.println(car.getColor() + " " + car.getModel() + " с номером " + car.getNumber() + " уехала с парковки под номером " + getPlace());
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }
}
