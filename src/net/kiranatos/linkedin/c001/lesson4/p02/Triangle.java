package net.kiranatos.linkedin.c001.lesson4.p02;

import java.util.*;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Triangle extends Shape{
    Scanner in = new Scanner(System.in);
    public Triangle(String name) {
        super("Triangle");
    }
    public double calculateArea()    {
        System.out.println("Enter the height and base of the triangle: ");
        double height = in.nextDouble();
        double base = in.nextDouble();
        return .5 * height * base;
    }       
}