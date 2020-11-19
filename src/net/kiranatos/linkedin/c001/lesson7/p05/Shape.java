package net.kiranatos.linkedin.c001.lesson7.p05;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 

The shape is class is the superclass */

public abstract class Shape {
    private String shapeName;
    private double area;
      
    public Shape()    {
        shapeName = "generic shape";
    }
    
    public Shape(String shapeName)    {
        this.shapeName = shapeName;
        area = 0;        
    }
    
    public Shape(String name, double area)    {
        this.shapeName = name;
        this.area = area;
    }
    
    public String getShapeName()    {
        return shapeName;
    }
    
    public abstract double calculateArea();    
}