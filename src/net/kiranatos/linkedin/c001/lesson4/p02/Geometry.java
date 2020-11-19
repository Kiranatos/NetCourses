package net.kiranatos.linkedin.c001.lesson4.p02;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Geometry {
    public static void main(String[] args) {
        Shape orange = new Circle("Orange");
        double area = orange.calculateArea();
        System.out.println("The area for the orange is: "+ area);
        Shape square = new Rectangle("Square");
        double area2 = square.calculateArea();
        System.out.println("The area of the square is: "+area2);
    }    
}
