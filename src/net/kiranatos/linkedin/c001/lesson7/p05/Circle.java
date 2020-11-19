package net.kiranatos.linkedin.c001.lesson7.p05;

import java.util.*;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Circle extends Shape {
    Scanner in = new Scanner(System.in);

    public Circle() {
        super("Circle");
    }
    
    public Circle(String name)    {
        super(name);
    }
    
    public double calculateArea()    {
        System.out.println("Enter the radius of the circle: ");
        double radius = in.nextDouble();
        return Math.PI*Math.pow(radius, 2);
    }       
}
