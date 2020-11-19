package net.kiranatos.linkedin.c001.lesson5;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 

Example of recursion */

public class RecursionExample {
    public static void main(String[] args) {
        System.out.println("The countdown has begun!!");
        countDown(10);
        System.out.println("blastoff");
    }
    
    public static void countDown(int count)    {
        if(count == 0) return;
        System.out.println(count + "...");
        countDown(count-1);
    }    
}