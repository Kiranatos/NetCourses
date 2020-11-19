package net.kiranatos.linkedin.c001.lesson7.p01;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Geometry {
    public static void main(String[] args) {
        Shape coin = new Circle("Coin");
        System.out.println("The area for the coin is: "+ coin.calculateArea());
        Shape square = new Rectangle();
        System.out.println("The area of the square is: "+square.calculateArea());
        Shape triangle = new Triangle("Pyramid");
        System.out.println("The area of the pyramid is "+triangle.calculateArea());
    }
}
