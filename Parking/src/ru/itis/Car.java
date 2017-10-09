package ru.itis;

public class Car {
    private ParkingPlace parkplace;
    private String model;
    private String color;
    private String number;
    public Car(String model, String color, String number){
        setColor(color);
        setModel(model);
        setNumber(number);
    }
    public void toPark(ParkingPlace parkplace){
        parkplace.parkCar(this);

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
    public void setNumber(String number) {
        this.number = number;
    }
    public String getColor() {
        return color;
    }
    public String getModel() {
        return model;
    }
    public String getNumber() {
        return number;
    }
    public void setParkposition(ParkingPlace parkplace){
        this.parkplace = parkplace;
    }
    public ParkingPlace getParkposition(){
        return parkplace;
    }
}
