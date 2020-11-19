package net.kiranatos.linkedin.c001.lesson7.p05;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Geometry {
    public static void main(String[] args) {
        Shape frisbee = new Circle("Frisbee");
        System.out.println("The area for the frisbee is: " + frisbee.calculateArea());
        Shape square = new Rectangle("Square");
        System.out.println("The area of the square is: " + square.calculateArea());
    }    
}
