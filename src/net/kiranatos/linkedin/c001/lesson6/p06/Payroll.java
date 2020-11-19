package net.kiranatos.linkedin.c001.lesson6.p06;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class Payroll {
    public static void main(String[] args) {
        Address a1 = new Address("123", "South Main Street", "Cleveland", "OH", "12345");
        Address a2 = new Address("123", "North Main Street", "Willoughby", "OH", "54321");
        Employee ee1 = new Employee("Peggy", "Fisher", "717-555-1212", a1, 955123, 003, "Lecturer",45000.00 );
        Employee ee2 = new Employee("Bob", "Fisher", "717-555-1212",a1, 955123, 003, "Lecturer",45500.00 );
        ee1.printEmployee();
        ee2.printEmployee();
    }
}