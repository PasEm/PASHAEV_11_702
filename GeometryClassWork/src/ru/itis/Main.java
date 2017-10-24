package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Box box = new Box(1,2,3,4,5,6);
	    Sphere sphere = new Sphere(1,2,3,5);
	    box.move(12,13,15);
	    sphere.move(1,2,3);
	    box.scale(12);
    }
}
