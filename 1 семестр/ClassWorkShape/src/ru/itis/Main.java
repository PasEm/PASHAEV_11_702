package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Quadrat quad1 = new Quadrat(5);
	    Ellips ell1 = new Ellips( 4, 3);
	    Circle cir1 = new Circle(1);
	    Rectangle rec1 = new Rectangle(4,5);
	    Shape shape[] = {ell1, cir1, rec1, quad1};
	    for (Shape shapes: shape){
            System.out.println(shapes.perimetr + " " + shapes.square);
        }
    }
}
