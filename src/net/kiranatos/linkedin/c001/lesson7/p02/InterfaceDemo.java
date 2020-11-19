package net.kiranatos.linkedin.c001.lesson7.p02;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class InterfaceDemo {
    public static void main(String[] args) {
        MountainBike Huffy = new MountainBike();
        Huffy.printStates();
        //update Bicycle info
        Huffy.changePedalRate(2);
        Huffy.speedUp(5);
        Huffy.changeGear(1);
        System.out.println("\nAfter updating the info: ");
        Huffy.printStates();
    }
    
}
