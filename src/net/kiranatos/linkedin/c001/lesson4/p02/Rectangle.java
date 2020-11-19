package net.kiranatos.linkedin.c001.lesson4.p02;

import java.util.*;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Rectangle extends Shape {
    Scanner in = new Scanner(System.in);
    public Rectangle(String name) {
        super("Rectangle");
    }
    public double calculateArea()    {
        System.out.println("Enter the length and width of the rectangle: ");
        double length = in.nextDouble();
        double width = in.nextDouble();
        return length * width;
    }       
}