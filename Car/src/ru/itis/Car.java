package ru.itis;

public class Car {
    private String model;
    private int power;
    private String color;
    private int distance;
    public  Car(){
        this.distance = 0;
        this.power = 0;
        this.model = "DEFAULT_MODEL";
        this.color = "DEFAULT_COLOR";
    }
    public Car(int power, String model){
        setPower(power);
        setModel(model);
    }
    public Car(int power, String model, int distance, String color){
        setModel(model);
        setColor(color);
        setDistance(distance);
        setPower(power);
    }
    public void setPower(int power) {
        if (power >= 0) {
            this.power = power;
        } else{
            System.out.println("Неверная мощность: значение по умолчанию");
            this.power = 0;
        }
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setDistance(int distance) {
        this.distance = 0;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getDistance() {
        return distance;
    }
    public int getPower() {
        return power;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public void going(int km){
        if (km < 0) {
            km = 0;
            System.out.println("Неверные входные данные: значение по умолчанию 0");
        }
        distance += km;
        System.out.println("Проехал " + distance + " километров");
    }
}
