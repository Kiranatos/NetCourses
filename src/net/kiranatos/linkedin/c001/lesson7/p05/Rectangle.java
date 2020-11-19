package net.kiranatos.linkedin.c001.lesson7.p05;

import java.util.*;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Rectangle extends Shape {
    Scanner in = new Scanner(System.in);
    
    public Rectangle()    {
        super("Rectangle");
    }
    
    public Rectangle(String name)    {
        super(name);
    }
    
    public double calculateArea()    {
        System.out.println("Enter the length and width of the rectangle: ");
        double length = in.nextDouble();
        double width = in.nextDouble();
        return length * width;
    }       
}