package ru.itis;

public class Car {
    private String model;
    private String color;
    private int number;
    private ParkingPlace parkingPlace;
    public Car(String model, String color, int number){
        setColor(color);
        setModel(model);
        setNumber(number);
    }
    public void toPark(ParkingPlace parkplace){
        parkplace.parkCar(this);
    }
    public void setParkingPlace(ParkingPlace parkingPlace){
        this.parkingPlace = parkingPlace;
    }
    public void toTake(ParkingPlace parkplace){
        parkplace.takeCar(this);
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setNumber(int number) {
            this.number = number;
    }
    public String getColor() {
        return color;
    }
    public String getModel() {
        return model;
    }
    public int getNumber() {
        return number;
    }
}
